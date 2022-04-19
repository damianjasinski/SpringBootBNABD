FROM maven:3.5.4-jdk-11

COPY docker_run_commands.sh /scripts/docker_run_commands.sh
RUN ["chmod", "+x", "/scripts/docker_run_commands.sh"]
ENTRYPOINT ["/scripts/docker_run_commands.sh"]
