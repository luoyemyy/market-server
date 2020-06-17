package com.github.luoyemyy.common.swagger

import com.github.luoyemyy.common.util.Const
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j
import com.google.common.collect.Lists
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.util.ClassUtils
import springfox.documentation.RequestHandler
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.ApiKey
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@EnableSwagger2
@EnableKnife4j
@Configuration
class Swagger {

    companion object {
        private val WE_CHAT_PACKAGE = arrayOf("com.github.luoyemyy")
        private val USER_PACKAGE = arrayOf("com.github.luoyemyy")
        private val DATA_PACKAGE = arrayOf("com.github.luoyemyy")
    }

    @ConditionalOnProperty(name = ["spring.application.name"], havingValue = "user")
    @Profile("dev", "default")
    @Bean(name = ["userApi"])
    fun userApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .groupName("用户服务")
                .apiInfo(apiInfo("用户服务文档"))
                .useDefaultResponseMessages(false)
                .select()
                .apis(apis(*USER_PACKAGE))
                .paths(PathSelectors.any())
                .build().securitySchemes(token())
    }

    @ConditionalOnProperty(name = ["spring.application.name"], havingValue = "data")
    @Profile("dev", "default")
    @Bean(name = ["dataApi"])
    fun wxApi(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
                .groupName("数据服务")
                .apiInfo(apiInfo("数据服务文档"))
                .useDefaultResponseMessages(false)
                .select()
                .apis(apis(*DATA_PACKAGE))
                .paths(PathSelectors.any())
                .build().securitySchemes(token())
    }


    @ConditionalOnProperty(name = ["spring.application.name"], havingValue = "wechat")
    @Profile("dev", "default")
    @Bean(name = ["wechatApi"])
    fun webApi(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
                .groupName("微信服务")
                .apiInfo(apiInfo("威胁你服务文档"))
                .useDefaultResponseMessages(false)
                .select()
                .apis(apis(*WE_CHAT_PACKAGE))
                .paths(PathSelectors.any())
                .build().securitySchemes(token())
    }

    private fun apiInfo(name: String): ApiInfo? {
        return ApiInfoBuilder().title(name).version("1.0").build()
    }

    private fun token(): List<ApiKey>? {
        return Lists.newArrayList(ApiKey("token", Const.TOKEN, "header"))
    }

    private fun apis(vararg packages: String): com.google.common.base.Predicate<RequestHandler?>? {
        return com.google.common.base.Predicate { input: RequestHandler? ->
            Optional.ofNullable(input)
                    .map { it: RequestHandler -> ClassUtils.getPackageName(it.declaringClass()) }
                    .map { it: String -> Arrays.stream(packages).anyMatch { prefix: String? -> it.startsWith(prefix!!) } }
                    .orElse(true)
        }
    }
}