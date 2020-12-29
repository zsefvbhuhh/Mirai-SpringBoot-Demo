package com.mirai.water.springbootdemo.qqbot;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Mehcell_Water
 * @date 2020/12/29 12:31
 */
@Component
@PropertySource("classpath:sweetBot.properties")
public class QBot {
    private static final Logger logger = LoggerFactory.getLogger(QBot.class);
    @Value("${bot.account}")
    public Long botAccount;
    @Value("${bot.pwd}")
    public String botPwd;

    private static Bot bot;
    public static Bot getBot() {
        return bot;
    }
    
    //设备认证信息文件
    private static final String deviceInfo = "device.json";

    /**
     * 启动BOT
     */
    public void startBot() {
        if (null == botAccount || null == botPwd) {
            System.err.println("*****未配置账号或密码*****");
            logger.warn("*****未配置账号或密码*****");
        }

        bot = BotFactory.INSTANCE.newBot(botAccount, botPwd, new BotConfiguration() {
            {
                //保存设备信息到文件deviceInfo.json文件里相当于是个设备认证信息
                fileBasedDeviceInfo(deviceInfo);
                setProtocol(MiraiProtocol.ANDROID_PHONE); // 切换协议
            }
        });
        bot.login();
        //可以向一个群发送消息进行测试
        bot.getGroup().sendMessage("嘎!");
    }
}
