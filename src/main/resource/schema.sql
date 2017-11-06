CREATE TABLE IF NOT EXISTS `student` (
    `id` int (
      11
    ) NOT NULL AUTO_INCREMENT , 
    `studentName` varchar (45) DEFAULT NULL, 
    PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `student_score` (
    `id` int (
      11
    ) NOT NULL AUTO_INCREMENT , 
    `student_id` int (11) DEFAULT NULL, 
    `subject` varchar (45) DEFAULT NULL, 
    `score` int (11) DEFAULT NULL, 
    PRIMARY KEY (`id`), 
    KEY `fk_stuname_idx` (
      `student_id` 
    ), 
    CONSTRAINT `fk_stuname` FOREIGN KEY (`student_id`) REFERENCES `student` (
      `id` 
    )
      ON DELETE NO ACTION 
          ON UPDATE
            NO ACTION 
          )ENGINE=InnoDB DEFAULT CHARSET=utf8;