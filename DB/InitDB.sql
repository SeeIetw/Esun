
CREATE DATABASE esun_voting;

USE esun_voting;

CREATE TABLE `terms` (
                         `termId` integer PRIMARY KEY AUTO_INCREMENT,
                         `termName` varchar(50)
);

CREATE TABLE `records` (
                           `recordId` integer PRIMARY KEY AUTO_INCREMENT,
                           `userName` varchar(50),
                           `termId` integer,
                           FOREIGN KEY (`termId`) REFERENCES `terms` (`termId`)
);

INSERT INTO terms (termName) VALUES ('電腦');
INSERT INTO terms (termName) VALUES ('滑鼠');


INSERT INTO records (userName, termId) VALUES ('Leo', 1);
INSERT INTO records (userName, termId) VALUES ('Sandy', 1);
INSERT INTO records (userName, termId) VALUES ('Sandy', 2);
INSERT INTO records (userName, termId) VALUES ('Randy', 2);
INSERT INTO records (userName, termId) VALUES ('RSY', 2);

DELIMITER //

CREATE PROCEDURE GetTermSum()
BEGIN
SELECT t.termId, t.termName, COUNT(r.termId) as `sum`
FROM terms t
         LEFT JOIN records r ON t.termId = r.termId
GROUP BY t.termId, t.termName;
END //

DELIMITER ;
