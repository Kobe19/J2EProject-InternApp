INSERT INTO GroupEfrei(name_Group) VALUES ('L1'), ('L2'), ('L3'),('M1SE'),('M2SE');

INSERT INTO Tutor(login_Tutor, password_Tutor, firstname_Tutor, lastname_Tutor) VALUES 
('jaugustin', '6dc23f96d89a1fd23197a3b5792abbb81288d019eca8c5d5d4437f71726309e6', 'Jacques', 'Augustin'),
('jsoma', '6dc23f96d89a1fd23197a3b5792abbb81288d019eca8c5d5d4437f71726309e6', 'Jean', 'Soma');

INSERT INTO Intern(firstname_Intern, lastname_Intern, group_Intern, linkedin_Intern) VALUES 
('Alex', 'Gomez', 4, 'Alexargo'), 
('Tristan', 'Clemenceau', 4, 'Tristan_cl'), 
('Mona', 'Diluc', 2, 'Monda'), 
('Mathias', 'Venti', 3, 'M_venti'), 
('Xian', 'Ling', 5, 'XianLing'), 
('Barbara', 'Delachaine', 5, 'Barbada'),
('Sana', 'Minatozaki', 4, 'Sanam'),
('Philippe', 'Pichon', 2, 'PPichon'),
('Rene', 'Lukoazek', 3, 'RLuko'),
('Quentin', 'Kixazo', 4, 'Qkix'),
('Henry', 'Arodji', 5, 'Henry_A'),
('Antoine', 'Posazek', 5, 'AntoinePos'),
('Jennie', 'Kim', 4, 'JenK'),
('Camille', 'Tiapot', 1, 'Catiap'),
('Jerome', 'Jojo', 3, 'Jojo'),
('Brice', 'Denice', 1, 'Benice'),
('Yaelle', 'Zeda', 4, 'Yzeda'),
('Laura', 'Darera', 4, 'LauraD');


INSERT INTO Company(name_Company,address_Company,supervisorname_Company) VALUES 
('Edf','HMmm','George'),
('SFR','HMmm','Bertrand'),
('Orange', '13 boulevard henry', 'Michel'),
('EFREI', '32 Avenue de la République', 'Thierry'),
('Apple', '42 rue de la Paix', 'Catherine'),
('Amazon', '2 rue du Gendarme', 'Anthony'),
('Facebook', '6 rue du Monde', 'Lena'),
('Total', '44 rue du Commerce', 'Joseph'),
('Twitter', '10 rue des Oiseaux', 'Patrick'),
('Ubisoft', '55 avenue de la Volvic', 'Karim'),
('Lacoste', '5 avenue Descartes', 'Popura'),
('Kleenex', '65 rue Maupassant', 'Lucas');

INSERT INTO Internship(dateStart_Internship, dateEnd_Internship, missionDescription_Internship, comment_Internship, techGrade_Internship, comGrade_Internship, specification_Internship, visitSheet_Internship, evalEntrsheet_Internship, webSurvey_Internship, report_Internship, defense_Internship, visitPlanified_Internship, visitDone_Internship) VALUES
('2020-01-01','2020-02-02', 'Create a website', 'No comment atm', '18.5', '20.0', FALSE, FALSE, FALSE, FALSE,FALSE, FALSE, FALSE,FALSE),
('2018-03-01','2018-10-02', 'Modify a website', 'No comment atm', '14.3', '16.3', FALSE, FALSE, FALSE, FALSE,FALSE, FALSE, FALSE,FALSE),
('2018-03-01','2018-10-02', 'Modify a website', 'No comment atm', '14.3', '16.3', FALSE, FALSE, FALSE, FALSE,FALSE, FALSE, FALSE,FALSE),
('2019-12-01','2020-07-30', 'Creating a software', 'Great work', '19.2', '19.2', TRUE, TRUE, TRUE, TRUE,TRUE, TRUE, TRUE, TRUE),
('2018-07-25','2019-02-25', 'Modifying a software', 'Good work can be better', '13.5', '17.2', TRUE, TRUE, TRUE, TRUE,TRUE, TRUE, TRUE, TRUE),
('2019-03-01','2019-10-02', 'Adding new methods to a project', 'No comment atm, need to find a date for the visit', '14.3', '16.3', TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, FALSE, FALSE),
('2018-03-01','2018-10-02', 'Creating a new software', 'No comment atm', '14.3', '16.3', FALSE, FALSE, FALSE, FALSE,FALSE, FALSE, FALSE, FALSE),
('2018-03-01','2018-10-02', 'Modify a website', 'No comment atm', '14.3', '16.3', FALSE, FALSE, FALSE, FALSE,FALSE, FALSE, FALSE,FALSE),
('2020-03-01','2020-10-31', 'Creating a software', 'Great work', '19.2', '19.2', TRUE, TRUE, TRUE, TRUE,TRUE, TRUE, TRUE, TRUE),
('2015-07-25','2016-02-25', 'Modifying a software', 'Good work can be better', '13.5', '17.2', TRUE, TRUE, TRUE, TRUE,TRUE, TRUE, TRUE, TRUE),
('2016-03-01','2016-10-02', 'Creating a new project', 'No comment atm, need to find a date for the visit', '14.3', '16.3', TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, FALSE, FALSE),
('2018-03-01','2018-10-02', 'Adding new methods', 'No comment atm', '14.3', '16.3', FALSE, FALSE, FALSE, FALSE,FALSE, FALSE, FALSE, FALSE);


INSERT INTO AssignedInternship(id_Internship,id_Intern,id_Company) VALUES (1,1,1), (2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(10,10,10);


INSERT INTO AssignedIntern VALUES (1,2), (2,1), (1,3), (2,4), (1,5), (2,6), (1,7), (2,8), (1,9), (1,10), (2,11), (1,12), (2,13), (1,14), (2,15), (1,16), (2,17), (1,18);