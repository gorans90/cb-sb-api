### Install from source

First, clone the project:

```bash
$ hg clone https://username:password@bitbucket.org/carbookteam/carbooksb
```

Then install dependencies and check to see it works.

```mvn
 mvn spring-boot:run
```

To run project in the debug mode please do following steps:

Step 1:
    go to the pom.xml
    find and uncomment following code:
        <jvmArguments>
            -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005
        </jvmArguments>
    or add it if it's not exits to the plugins part like this:
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
             <jvmArguments>
                    -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005
              </jvmArguments>
              <addResources>true</addResources>
            </configuration>
        </plugin>
Step 2:
    reimport maven changes
Step 3:
    If you are using IntelliJ, go to the Run -> Edit configuration
    Click on + button and select Remote
    Left all as it is, debug port should be 5005
    Just add the name which you want and save
Step 4:
    run project with command:
        mvn spring-boot:run
Step 5:
    When you see the following message:
        "Listening for transport dt_socket at address: 5005"
    Go to the Run -> Debug and select the created one and you should see this console message
        "Connected to the target VM, address: 'localhost:5005', transport: 'socket'"
Step 6:
    Wait until you see following message:
        "CarBook applications: started..."
    Set the breakpoint and start debugging