package org.legou.imagePush // 1. 必须声明包名

// 2. 必须实现 Serializable 接口，否则 Jenkins 会报错 "NotSerializableException"
class imagePushUtils implements Serializable {

    // 定义一个脚本上下文变量
    def script

    // 构造函数：接收 pipeline 上下文 (this)
    imagePushUtils(script) {
        this.script = script
    }

    // 定义你的方法
    def pushImage(String imageName) {
        // 在这里调用 Jenkins 步骤时，必须用 script. 前缀
        script.echo "正在使用工具类推送镜像: ${imageName}"
        
        script.sh "docker push ${imageName}"
    }

    // 如果你想写静态工具方法（不需要 new 对象），可以这样写
    // 静态方法也必须把 script 对象传进来才能执行 sh 命令
    static void staticPush(def script, String imageName) {
        script.echo "静态方法推送: ${imageName}"
    }
}