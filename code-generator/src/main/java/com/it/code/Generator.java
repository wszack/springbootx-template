package com.it.code;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;
import java.sql.Types;

public class Generator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sky_take_out?ServerTimeZone=UTC";
        String username = "root";
        String password = "root";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("zhangzhicai") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(Paths.get(System.getProperty("user.dir")) + "/code-generator/src/main/java") // 指定输出目录
                            .commentDate("yyyy-MM-dd")
                            .disableOpenDir();
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                                builder.parent("com.it") // 设置父包名
                                .moduleName("springbootx") // 设置父包模块名
                                        .entity("entity")
                                        .mapper("mapper")
                                        .service("service")
                                        .serviceImpl("service.impl")
                                        .xml("mapper.xml")
                )
                .strategyConfig(builder ->
                                builder.addInclude("dish") // 设置需要生成的表名
                                //.addTablePrefix("tb_") // 设置过滤表前缀
                                        .entityBuilder()
                                        .enableLombok()
                                        .enableTableFieldAnnotation()
                                        .controllerBuilder()
                                        .enableRestStyle()
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
