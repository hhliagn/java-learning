package com.javalearning.demo.swagger_export;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws MalformedURLException {
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();
        // swagger-ui.html页面中能找到此链接
        Swagger2MarkupConverter.from(new URL("http://oryx-order.test3.rongxin.tech/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("D:\\files\\youxin\\"));

//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
//                .withOutputLanguage(Language.ZH)
//                .withPathsGroupedBy(GroupBy.TAGS)
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL("http://oryx-order.test3.rongxin.tech/v2/api-docs"))
//                .withConfig(config)
//                .build()
//                .toFolder(Paths.get("D:\\files\\youxin\\"));
    }
}
