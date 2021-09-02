package com.swain;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CodeGenerator {

    @Test
    public void genCode() {
        //模块名称
        String moduleName = "myshop";
        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        //拿到当前项目具体的目录
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        //作者信息
        gc.setAuthor("swain");
        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setServiceName("%sService"); //去掉Service接口的首字母I（基于习惯和适配一些技术接口不加I）
        gc.setIdType(IdType.ID_WORKER_STR); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(true);//开启Swagger2模式
        //配置到代码生成器中
        mpg.setGlobalConfig(gc);
        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/" + moduleName);//jdbc:mysql://localhost:3306/test
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");//数据库用户名
        dsc.setPassword("123456");//数据库密码
        //数据源类型
        dsc.setDbType(DbType.MYSQL);
        //配置到代码生成器中
        mpg.setDataSource(dsc);
        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName); //模块名
        pc.setParent("com.swain.myshop");
        //默认的包名，可以不写，也可以自定义
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        //配置到代码生成器中
        mpg.setPackageInfo(pc);
        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("\\w*");//设置要映射的表名（支持正则表达式，此处映射所有的表）
//        strategy.setInclude(moduleName + "_\\w*");//如果表名前面有模块名称就使用这样的方式设置要映射的表名（支持正则表达式，此处映射test_下所有的表）
//        strategy.setInclude(moduleName + "_user*");//单独设置要映射的表名(只映射test_user表)
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略（下划线策略）
        strategy.setTablePrefix(pc.getModuleName() + "_");//设置表前缀不生成（test_是表的前缀，会自动抛弃）
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setLogicDeleteFieldName("is_deleted");//逻辑删除字段名（会自动添加@TableLogic注解）
        //strategy.setEntityBooleanColumnRemoveIsPrefix(true);//去掉布尔值的is_前缀（映射的字段就会变成deleted）
        //自动填充
        TableFill gmtCreate = new TableFill("created_time", FieldFill.INSERT);//新增的时候自动填充，添加字段@TableField(fill = FieldFill.INSERT)注解
        TableFill gmtModified = new TableFill("modified_time", FieldFill.INSERT_UPDATE);//新增和修改时自动填充
        ArrayList<TableFill> tableFills = new ArrayList<TableFill>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);
        strategy.setVersionFieldName("version");//乐观锁列（在version字段上自动添加@version注解）
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符(中划线风格，eg:course-description/1)
        mpg.setStrategy(strategy);
        // 6、执行
        mpg.execute();
    }
}