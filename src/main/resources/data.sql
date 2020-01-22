
INSERT INTO `AUTHOR`(ID, NAME)
VALUES
(1, 'Maciej aniserowicz'),
(2, 'Tom Butler-Browdon');

INSERT INTO `BOOK`(ID, NAME, PAGE, PRICE, RENT, AUTHOR_ID)
VALUES
(1, 'Zawód programista',288 ,69 , FALSE, 1),
(2, 'Złota 50 podreczników samodoskonalenia' ,311 ,29 , FALSE, 2),
(3, 'Zaufanie waluta przyszłoci',188 ,80 , FALSE, 1);