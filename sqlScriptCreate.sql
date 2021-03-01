CREATE DATABASE IF NOT EXISTS st2eedb;
CREATE TABLE Tutor(
	id_Tutor int NOT NULL AUTO_INCREMENT,
	login_Tutor varchar(320),
	password_Tutor varchar(255),
	firstname_Tutor varchar(255),
	lastname_Tutor varchar(255),
	CONSTRAINT PK_Tutor PRIMARY KEY(id_Tutor)
);

CREATE TABLE Company(
	id_Company int NOT NULL AUTO_INCREMENT,
	name_Company varchar(255),
	address_Company varchar(255),
	supervisorName_Company varchar(255),
	CONSTRAINT PK_Company PRIMARY KEY(id_Company)
);

CREATE TABLE GroupEfrei(
	id_Group int NOT NULL AUTO_INCREMENT,
	name_Group varchar(25),
	CONSTRAINT PK_Group PRIMARY KEY(id_Group)
);

CREATE TABLE Internship(
	id_Internship int NOT NULL AUTO_INCREMENT,
	dateStart_Internship Date,
	dateEnd_Internship Date,
	missionDescription_Internship text,
	comment_Internship text,
	techGrade_Internship float,
	comGrade_Internship float,
	specification_Internship boolean,
	visitSheet_Internship boolean,
	evalEntrSheet_Internship boolean,
	webSurvey_Internship boolean,
	report_Internship boolean,
	defense_Internship boolean,
	visitPlanified_Internship boolean,
	visitDone_Internship boolean,
	CONSTRAINT PK_Internship PRIMARY KEY(id_Internship)
);

CREATE TABLE Intern(
	id_Intern int NOT NULL AUTO_INCREMENT,
	firstname_Intern varchar(255),
	lastname_Intern varchar(255),
	group_Intern int,
	linkedin_Intern varchar(255),
	CONSTRAINT PK_Intern PRIMARY KEY(id_Intern),
	CONSTRAINT FK_Intern FOREIGN KEY (group_Intern) REFERENCES GroupEfrei(id_Group)
);

CREATE TABLE AssignedIntern(
	id_Tutor int NOT NULL,
	id_Intern int NOT NULL,
	CONSTRAINT PK_AssignedIntern PRIMARY KEY(id_Tutor,id_Intern),
	CONSTRAINT FK_AssignedIntern_Tutor FOREIGN KEY (id_Tutor) REFERENCES Tutor(id_Tutor),
	CONSTRAINT FK_AssignedIntern_Inter FOREIGN KEY (id_Intern) REFERENCES Intern(id_Intern)
	
);

CREATE TABLE AssignedInternship(
	id_Internship int NOT NULL,
	id_Intern int NOT NULL,
	id_Company int NOT NULL,
	CONSTRAINT PK_AssignedInternship PRIMARY KEY(id_Internship,id_Intern,id_Company),
	CONSTRAINT FK_AssignedInternship_Intership FOREIGN KEY (id_Internship) REFERENCES Internship(id_Internship),
	CONSTRAINT FK_AssignedInternship_Inter FOREIGN KEY (id_Intern) REFERENCES Intern(id_Intern),
	CONSTRAINT FK_AssignedInternship_Company FOREIGN KEY (id_Company) REFERENCES Company(id_Company)
);
