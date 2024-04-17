package com.snykta.gen.controller;

import cn.hutool.core.io.IoUtil;
import com.snykta.gen.dto.SearchDto;
import com.snykta.gen.dto.TableDto;
import com.snykta.gen.service.GeneratorService;
import com.snykta.tools.utils.CyStrUtil;
import com.snykta.tools.web.page.PageDto;
import com.snykta.tools.web.result.Ret;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 代码生成器
 *
 */
@Controller
@RequestMapping("gen")
@ConditionalOnProperty(name = "gen.code.config.enable", havingValue = "true")
public class GeneratorController {


    private final GeneratorService sysGeneratorService;

    public GeneratorController(GeneratorService sysGeneratorService) {
        this.sysGeneratorService = sysGeneratorService;
    }

    /**
     * 分页
     */
    @ResponseBody
    @PostMapping("/queryPage")
    public Ret<PageDto<TableDto>> queryPage(@RequestBody SearchDto searchDto) {
        return Ret.success(sysGeneratorService.queryPage(searchDto));
    }


    /**
     * 生成代码压缩包
     */
    @GetMapping("/code")
    public void code(@RequestParam("tables") String tables,@RequestParam("packName") String packName, HttpServletResponse response) throws Exception {
        byte[] data = sysGeneratorService.generatorCode(CyStrUtil.splitToArray(tables, ","), packName);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"GenCode.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IoUtil.write(response.getOutputStream(), false, data);
    }


}
