package com.lkc1009.pixiv.business.tool.photo;

import cn.hutool.core.io.FileUtil;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;


@Slf4j
public class Compress {
    public static void compressPicForScale(String srcPath, String desPath, Long desFileSize, Long accuracy) {
        if (StringUtils.isBlank(srcPath) || StringUtils.isBlank(desPath)) {
            return;
        }

        File srcFile = FileUtil.file(srcPath);

        if (!srcFile.exists()) return;

        if (accuracy <= 0) {
            log.info("压缩系数太小");
            return;
        }

        try {
            long srcFileSize = srcFile.length();
            log.info("源图片：{} \t 大小：{} kb", srcPath, srcFileSize / 1024);

            Thumbnails.of(srcPath).scale(1f).toFile(desPath);
            compressPicCycle(desPath, desFileSize, Double.valueOf(accuracy));

            File desFile = FileUtil.file(desPath);
            log.info("目标图片：{} \t 大小：{} kb", desPath, desFile.length() / 1024);
        } catch (Exception e) {
            log.error("目标图片：{} \t 失败：{}", desPath, e);
        }
    }

    private static void compressPicCycle(String sourcePath, Long desFileSize, Double accuracy) throws IOException {
        if (accuracy >= 0.9) {
            log.info("压缩系数太大：{}", accuracy);
            accuracy = 0.8;
        }

        File sourceFile = FileUtil.file(sourcePath);

        long sourceFileSize = sourceFile.length();
        double max = desFileSize * 1.2 * 1024, min = desFileSize * 0.8 * 1024;

        if (sourceFileSize < min || (min < sourceFileSize && sourceFileSize < max)) {
            return;
        }

        max = desFileSize * 2048;
        if (sourceFileSize < max) {
            accuracy = 0.85;
        }

        BufferedImage bim = ImageIO.read(sourceFile);
        int bimWidth = bim.getWidth();
        int bimHeight = bim.getHeight();
        int desWidth = new BigDecimal(bimWidth).multiply(new BigDecimal(accuracy)).intValue();
        int desHeight = new BigDecimal(bimHeight).multiply(new BigDecimal(accuracy)).intValue();

        Thumbnails.of(sourcePath).size(desWidth, desHeight).outputQuality(accuracy).toFile(sourcePath);
        compressPicCycle(sourcePath, desFileSize, accuracy);
    }
}
