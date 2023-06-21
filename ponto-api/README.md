# Ponto-API

## How to Run on linux


### Step 1: Install JDK Binaries

```sh
    wget https://download.oracle.com/java/20/latest/jdk-20_linux-x64_bin.tar.gz
    tar -xvf jdk-20_linux-x64_bin.tar.gz
    mv jdk-20.0.1 /opt/
```

### Step 2: Configure Java enviroment variable

```sh
    JAVA_HOME='/opt/jdk-20.0.1'
    PATH="$JAVA_HOME/bin:$PATH"
    export PATH
```

### Step 3: Check java instalation

```sh
java -version
```
expect output

```sh
openjdk version "20.0.1" 2023-04-18
OpenJDK Runtime Environment (build 20.0.1+9-29)
OpenJDK 64-Bit Server VM (build 20.0.1+9-29, mixed mode, sharing)
```
### Step 4: Install Maven

```sh
wget https://dlcdn.apache.org/maven/maven-3/3.9.2/binaries/apache-maven-3.9.2-bin.tar.gz
tar -xvf apache-maven-3.9.2-bin.tar.gz
mv apache-maven-3.9.2 /opt/
```

### Step 5: Step 2: Configure Maven enviroment variables
```sh
M2_HOME='/opt/apache-maven-3.9.2'
PATH="$M2_HOME/bin:$PATH"
export PATH
```

### Step 6: Check Maven instalation

```sh
mvn -version
```
expect output

```sh
Java version: 20.0.1, vendor: Oracle Corporation, runtime: /opt/jdk-20.0.1
Default locale: pt_BR, platform encoding: UTF-8
OS name: "linux", version: "5.19.0-45-generic", arch: "amd64", family: "unix"
```

### Step 7: Build Project ponto-api
```sh
cd ./ponto-api/
mvn package
```

### Stop 8: Run docker-compose
```sh
docker-compose up -d
```