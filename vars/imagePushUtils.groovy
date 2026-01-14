// vars/imagePushUtils.groovy

// 定义一个方法，名字要和你调用的方法名一致
def image2Acr(String credId, String fullImageName, String registry, String project) {
    // 在 vars 目录下，可以直接使用 sh, echo, withCredentials，不需要 script. 前缀
    echo "GTOPS-SDK: 推送镜像 ${fullImageName} 到 ${registry}"

    withCredentials([usernamePassword(credentialsId: credId, usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh """
            echo \$PASS | docker login -u \$USER --password-stdin ${registry}
            docker push ${fullImageName}
            docker logout ${registry}
        """
    }
}