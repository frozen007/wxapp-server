# wxapp-server

## ticket service
```sql
# 建表脚本
CREATE TABLE `id_ticket` (
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
`ticket_name` varchar(10) NOT NULL,
`current_id` bigint(20) unsigned NOT NULL,
`step` int(11) NOT NULL,
`creation_time` bigint(20) NOT NULL,
`update_time` bigint(20) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `idx_ticket_name` (`ticket_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='id生成表'

# 初始化脚本
insert into id_ticket(ticket_name, current_id, step, creation_time, update_time) values('test_id', 1, 5, unix_timestamp(), unix_timestamp());
```


