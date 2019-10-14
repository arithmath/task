FROM mysql:8.0.16

COPY init.sql /docker-entrypoint-initdb.d/

ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_USER user
ENV MYSQL_PASSWORD password
ENV MYSQL_DATABASE task

ENTRYPOINT ["docker-entrypoint.sh"]
CMD ["mysqld", "--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci"]
