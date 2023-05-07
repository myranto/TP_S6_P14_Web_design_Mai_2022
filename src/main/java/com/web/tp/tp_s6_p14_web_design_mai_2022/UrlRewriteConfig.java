package com.web.tp.tp_s6_p14_web_design_mai_2022;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

@Configuration
@ServletComponentScan
public class UrlRewriteConfig extends UrlRewriteFilter {
}
