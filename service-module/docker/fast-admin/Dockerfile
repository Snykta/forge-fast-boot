# 基础镜像
FROM  openjdk:8-jre
# 作者
MAINTAINER snykta

# 挂载目录
VOLUME /home/snykta
# 创建目录
RUN mkdir -p /home/snykta
# 指定路径
WORKDIR /home/snykta
# 复制jar文件到路径
COPY ./jar/fast-admin.jar /home/snykta/fast-admin.jar
# 启动服务
ENTRYPOINT ["java","-jar","fast-admin.jar"]