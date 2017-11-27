CREATE DATABASE VirgoHospital
GO
USE VirgoHospital
GO

CREATE table ContactDetailsAddress(
	[IDContactDetailsAddress] int primary key identity
	,DoorNumber nvarchar(10) not null DEFAULT '-'
	,Street nvarchar(30) not null DEFAULT '-'
	,Area nvarchar(30) null DEFAULT '-'
	,City nvarchar(30) not null DEFAULT '-'
	,[State] nvarchar(50) not null DEFAULT '-'
	,Pincode nvarchar(50) not nulL DEFAULT '-'
)

create table ContactDetailsContact(
	IDContactDetailsContact int primary key identity
	,TelephoneWork nvarchar(25) null DEFAULT '-'
	,TelephoneHome nvarchar(25) null DEFAULT '-'
	,Mobile nvarchar(25) null DEFAULT '-'
	,Pager nvarchar(25) null DEFAULT '-'
	,Fax nvarchar(25) null DEFAULT '-'
	,Email nvarchar(50) null DEFAULT '-'
)

create table PersonalDetails(
	[IDpersonalDetails] int primary key identity
    ,[MaritalStatus] nvarchar(10) not null  DEFAULT '-'
	,[NumberOfDependents] nvarchar(10) not null  DEFAULT '-'
	,[Height] nvarchar(10) not null  DEFAULT '-'
	,[Weight] nvarchar(10) not null DEFAULT '-'
	,[BloodType] nvarchar(10) not null DEFAULT '-'
)

create table Lifestyle(
	IDlifestyle int primary key identity
	,Vegetarian bit not null DEFAULT 0
	,Smoker bit not null DEFAULT 0
	,AverageNoOfCigarettes int not null DEFAULT 0
	,Alcoholic bit not null DEFAULT 0
	,AverageNoOfDrinks int not null DEFAULT 0
	,UseStimulants nvarchar(200) not null DEFAULT '-'
	,ConsumptionOfCoffeeAndTea int not null DEFAULT 0
	,ConsumptionOfSoftDrinks int not null DEFAULT 0
	,HaveRegularMeals bit not null DEFAULT 0
	,HomeFood bit not null DEFAULT 0
)

create table ImportantMedicalComplaints(
	IDimportantMedicalComplaints int primary key identity
	,Diabetic bit not null DEFAULT 0
	,Hypertensive bit not null DEFAULT 0
	,CardiacCondition nvarchar(50) not null DEFAULT '-'
	,DigestiveCondition nvarchar(50) not null DEFAULT '-'
	,OrthopedicCondition nvarchar(50) not null DEFAULT '-'
	,MuscularCondition nvarchar(50) not null DEFAULT '-'
	,NeurogicalCondition nvarchar(50) not null DEFAULT '-'
	,KnownAllergies nvarchar(200) not null DEFAULT '-'
	,KnownReactionToSpecificDrugs nvarchar(200) not null DEFAULT '-'
	,MajorSurgeries nvarchar(200) not null DEFAULT '-'
)

create table BasicComplaints(
	IDBasicComplaints int primary key identity
	,StatementOfComplaint nvarchar(200) not null DEFAULT '-'
	,HistoryOfPreviousTreatment nvarchar(2000) not null DEFAULT '-'
	,PhysicianOrHospital nvarchar(20) not null DEFAULT '-'
)

create table ProfessionDetails(
	IDProfessionDetails int primary key identity
	,Occupation nvarchar(50) not null DEFAULT '-'
	,GrossAnnualIncome int not null DEFAULT 0
)

create table NextOfKin(
	[IDNextOfKin] int primary key identity
	,[Name] nvarchar(50) not null DEFAULT '-'
	,Surname nvarchar(50) not null DEFAULT '-'
	,Middlename nvarchar(50) null DEFAULT '-'
	,Relationship nvarchar(50) not null DEFAULT '-'
	,ContactDetailsContactID int foreign key references ContactDetailsContact(IDContactDetailsContact)
	,ContactDetailsAddressID int foreign key references ContactDetailsAddress(IDContactDetailsAddress)
)

CREATE TABLE Patient(
	IDpatient int primary key identity
	,[Name] nvarchar(50) not null DEFAULT '-'
	,Surname nvarchar(50) not null DEFAULT '-'
	,Middlename nvarchar(50) null DEFAULT '-'
	,Sex nvarchar(1) not null DEFAULT 'M'
	,StatementOfComplaint nvarchar(1000) not null DEFAULT '-'
	,ContactPhone_1 nvarchar(25) null DEFAULT '-'
	,ContactPhone_2 nvarchar(25) null DEFAULT '-'
	,NextOfKinID int foreign key references NextOfKin(IDNextOfKin)
	,IsFollowUp bit not null default 0
)

create table PatientFull(
	IDPatientFull int primary key identity,
	PatientID int foreign key references Patient(IDpatient),
	DateOfBirth date not null DEFAULT '19700101',
	PermanentAdressID int foreign key references ContactDetailsAddress(IDContactDetailsAddress),
	PresentAdressID int foreign key references ContactDetailsAddress(IDContactDetailsAddress),
	ContactDetailsContactID int FOREIGN KEY REFERENCES ContactDetailsContact(IDContactDetailsContact),
	PersonalDetailsID int foreign key references PersonalDetails(IDPersonalDetails),
	ProfessionDetailsID int foreign key references ProfessionDetails(IDProfessionDetails),
	LifestyleID int foreign key references Lifestyle(IDLifestyle),
	BasicComplaintsID int foreign key references BasicComplaints(IDBasicComplaints),
	ImportantMedicalComplaintsID int foreign key references ImportantMedicalComplaints(IDImportantMedicalComplaints)
)

CREATE TABLE Specialization(
	IDSpecialization int primary key identity
	,Specialization nvarchar(50) not null
	CONSTRAINT UC_Specialization UNIQUE(Specialization)
)

CREATE TABLE Doctor (
	IDDoctor int primary key identity
	,[Name] nvarchar(50) DEFAULT '-'
	,Surname nvarchar(50) DEFAULT '-'
	,IsActive bit not null default 1
	,ContactDetailsContactID int FOREIGN KEY REFERENCES ContactDetailsContact(IDContactDetailsContact)
	,ContactDetailsAddressID int FOREIGN KEY REFERENCES ContactDetailsAddress(IDContactDetailsAddress)
	,SpecializationID int foreign key references Specialization(IDSpecialization)
)

CREATE TABLE Appointment(
	IDAppointment int primary key identity
	,DateOfAppointment date not null
	,TimeOfAppointmentStart time not null
	,TimeOfAppointmentEnd time not null
	,DoctorID int foreign key references Doctor(IDDoctor)
	,PatientFullID int foreign key references PatientFull(IDPatientFull)
	,AppointmentSummary nvarchar(500) DEFAULT '-'
	,OrderedTests nvarchar(500) DEFAULT '-'
	,PrescribedMedicine nvarchar(500) DEFAULT '-'
	,OrderedTreatment nvarchar(500) DEFAULT '-'
)

create table Bill(
	IDBill int primary key identity
	,PaymentMethod nvarchar(50) DEFAULT '-'
	,PatientFullID int foreign key references PatientFull(IDPatientFull)
	,BillDate date not null
	,BillTime time not null
)

create table AccountItem(
	[IDAccountItem] int primary key identity
	,[ItemName] nvarchar(50) DEFAULT '-'
	,[ItemPrice] float DEFAULT 0
	,[ItemQuantity] int DEFAULT 1
	,[BillID] int foreign key references Bill(IDBill)
)


GO
CREATE PROC InsertSpecialization
	@Specialization nvarchar(50)
AS
BEGIN
	INSERT INTO Specialization([Specialization])
	VALUES (@Specialization)
END

GO
CREATE PROC GetSpecializations
AS
BEGIN
	SELECT IDSpecialization,
	       Specialization
	FROM Specialization
END

GO
CREATE PROC GetSpecialization
	@IDSpectialization int
AS
BEGIN
	SELECT IDSpecialization,
	       Specialization
	FROM Specialization
	WHERE IDSpecialization = @IDSpectialization
END

GO
CREATE PROC DeleteSpecialization
	@IDSpecialization int
AS
BEGIN
	DELETE FROM [dbo].[Specialization]
	WHERE [IDSpecialization] = @IDSpecialization
END

GO
CREATE PROC UpdateSpecialization
	@IDSpecialization int,
	@Specialization nvarchar(50)
AS
BEGIN
	UPDATE [dbo].[Specialization]
	SET [Specialization] = @Specialization
	WHERE [IDSpecialization] = @IDSpecialization
END

GO
CREATE PROC InsertContactDetailsContact
	@TelephoneWork nvarchar(25),
	@TelephoneHome nvarchar(25),
	@Mobile nvarchar(25),
	@Pager nvarchar(25),
	@Fax nvarchar(25),
	@Email nvarchar(25)
AS
BEGIN
	INSERT INTO ContactDetailsContact
	(TelephoneWork, TelephoneHome, Mobile, Pager, Fax, Email)
	VALUES
	(@TelephoneWork, @TelephoneHome, @Mobile, @Pager, @Fax, @Email)

	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC GetContactDetailsContact
	@IDContactDetailsContact int
AS
BEGIN
	SELECT IDContactDetailsContact,
		   TelephoneWork,
		   TelephoneHome,
		   Mobile,
		   Pager,
		   Fax,
		   Email
	FROM ContactDetailsContact
	WHERE IDContactDetailsContact = @IDContactDetailsContact
END

GO
CREATE PROC UpdateContactDetailsContact
	@IDContactDetailsContact int
   ,@TelephoneWork nvarchar(25)
   ,@TelephoneHome nvarchar(25)
   ,@Mobile nvarchar(25)
   ,@Pager nvarchar(25)
   ,@Fax nvarchar(25)
   ,@Email nvarchar(25)
AS
BEGIN
	UPDATE [dbo].[ContactDetailsContact]
	SET [TelephoneWork] = @TelephoneWork
	   ,[TelephoneHome] = @TelephoneHome
	   ,[Mobile] = @Mobile
	   ,[Pager] = @Pager
	   ,[Fax] = @Fax
	   ,[Email] = @Email
	WHERE [IDContactDetailsContact] = @IDContactDetailsContact
END

GO
CREATE PROC InsertContactDetailsAddress
	@DoorNumber nvarchar(10)
   ,@Street nvarchar(30)
   ,@Area nvarchar(30)
   ,@City nvarchar(30)
   ,@State nvarchar(50)
   ,@Pincode nvarchar(50)
AS
BEGIN
	INSERT INTO [dbo].[ContactDetailsAddress]
	([DoorNumber]
	,[Street]
	,[Area]
	,[City]
	,[State]
	,[Pincode])
	VALUES
	(@DoorNumber
	,@Street
	,@Area
	,@City
	,@State
	,@Pincode)

	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC GetContactDetailsAddress
	@IDContactDetailsAddressID int
AS
BEGIN
	SELECT IDContactDetailsAddress,
	       DoorNumber,
		   Street,
		   Area,
		   City,
		   [State],
		   Pincode
	FROM ContactDetailsAddress
	WHERE [IDContactDetailsAddress] = @IDContactDetailsAddressID
END

GO
CREATE PROC UpdateContactDetailsAddress
	@IDContactDetailsAddress int
   ,@DoorNumber nvarchar(10)
   ,@Street nvarchar(30)
   ,@Area nvarchar(30)
   ,@City nvarchar(30)
   ,@State nvarchar(50)
   ,@Pincode nvarchar(50)
AS
BEGIN
	UPDATE [dbo].[ContactDetailsAddress]
	SET [DoorNumber] = @DoorNumber
	   ,[Street] = @Street
	   ,[Area] = @Area
	   ,[City] = @City
	   ,[State] = @State
	   ,[Pincode] = @Pincode
	WHERE [IDContactDetailsAddress] = @IDContactDetailsAddress
END

GO
CREATE PROC InsertDoctor
	@Name nvarchar(50)
   ,@Surname nvarchar(50)
   ,@ContactDetailsContactID int
   ,@ContactDetailsAddressID int
   ,@SpecializationID int
   ,@IsActive bit
AS
BEGIN
	INSERT INTO [dbo].[Doctor]
	([Name]
	,[Surname]
	,[SpecializationID]
	,[ContactDetailsContactID]
	,[ContactDetailsAddressID]
	,[IsActive])
	VALUES
	(@Name
	,@Surname
	,@SpecializationID
	,@ContactDetailsContactID
	,@ContactDetailsAddressID
	,@IsActive)
END

GO
CREATE PROC UpdateDoctor
	@IDDoctor int,
	@Name nvarchar(50),
	@Surname nvarchar(50),
	@SpecializationID int
AS
BEGIN
	UPDATE [dbo].[Doctor]
	SET [Name] = @Name
	   ,[Surname] = @Surname
	   ,[SpecializationID] = @SpecializationID
	WHERE [IDDoctor] = @IDDoctor
END

GO
CREATE PROC UpdateDoctorIsActive
	@IDDoctor int,
	@IsActive bit
AS
BEGIN
	UPDATE [dbo].[Doctor]
	SET [IsActive] = @IsActive
	WHERE [IDDoctor] = @IDDoctor
END

GO
CREATE PROC DeleteDoctor
	@IDDoctor int
AS
BEGIN
	DELETE FROM [dbo].[Doctor]
	WHERE [IDDoctor] = @IDDoctor
END



GO
CREATE PROC GetDoctor
	@IDDoctor int
AS
BEGIN
	SELECT [Name]
		  ,[Surname]
		  ,[ContactDetailsContactID]
		  ,[ContactDetailsAddressID]
	      ,[SpecializationID]
		  ,[IsActive]
	FROM Doctor
	WHERE [IDDoctor] = @IDDoctor
END

GO
CREATE PROC GetAllDoctors
AS
BEGIN
	SELECT [IDDoctor]
	      ,[Name]
		  ,[Surname]
		  ,[ContactDetailsContactID]
		  ,[ContactDetailsAddressID]
	      ,[SpecializationID]
	FROM Doctor WHERE [IsActive] = 1
END

GO
CREATE PROC InsertNextOfKin
	@Name nvarchar(50),
	@Surname nvarchar(50),
	@Middlename nvarchar(50),
	@Relationship nvarchar(50),
	@ContactDetailsContactID int,
	@ContactDetailsAddressID int
AS
BEGIN
	INSERT INTO [dbo].[NextOfKin]
		([Name]
		,[Surname]
		,[Middlename]
		,[Relationship]
		,[ContactDetailsContactID]
		,[ContactDetailsAddressID])
	VALUES
		(@Name
		,@Surname
		,@Middlename
		,@Relationship
		,@ContactDetailsContactID
		,@ContactDetailsAddressID)

	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC UpdateNextOfKin
	 @IDNextOfKin int
	,@Name nvarchar(50)
	,@Surname nvarchar(50)
	,@Middlename nvarchar(50)
	,@Relationship nvarchar(50)
AS
BEGIN
	UPDATE [dbo].[NextOfKin]
	SET [Name] = @Name
	   ,[Surname] = @Surname
	   ,[Middlename] = @Middlename
	   ,[Relationship] = @Relationship
	WHERE [dbo].[NextOfKin].IDNextOfKin = @IDNextOfKin
END

GO
CREATE PROC GetNextOfKin
	@IDNextOfKin int
AS
BEGIN
	SELECT [IDNextOfKin],
		   [Name],
		   [Surname],
		   [Middlename],
		   [Relationship],
		   [ContactDetailsContactID],
		   [ContactDetailsAddressID]
	FROM [NextOfKin]
	WHERE [IDNextOfKin] = @IDNextOfKin
END

GO
CREATE PROC InsertPatient
	@Name nvarchar(50),
	@Surname nvarchar(50),
	@Middlename nvarchar(50),
	@Sex  nvarchar(1),
	@StatementOfComplaint nvarchar(1000),
	@ContactPhone_1 nvarchar(25),
	@ContactPhone_2 nvarchar(25),
	@NextOfKinID int,
	@IsFollowUp bit
AS
BEGIN
	INSERT INTO Patient
	([Name], [Surname], [Middlename], [Sex], [StatementOfComplaint], [ContactPhone_1], [ContactPhone_2], [NextOfKinID], [IsFollowUp])
	VALUES
	(@Name, @Surname, @Middlename, @Sex, @StatementOfComplaint, @ContactPhone_1, @ContactPhone_2, @NextOfKinID, @IsFollowUp)

	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC  GetPatients
AS
BEGIN
	SELECT [IDpatient]
		   [Name],
		   [Surname],
		   [Middlename],
		   [Sex],
		   [StatementOfComplaint],
		   [ContactPhone_1],
		   [ContactPhone_2],
		   [NextOfKinID],
		   [IsFollowUp]
	FROM Patient
END

GO
CREATE PROC GetPatient
	@IDPatient int
AS
BEGIN
	SELECT [Name],
		   [Surname],
		   [Middlename],
		   [Sex],
		   [StatementOfComplaint],
		   [ContactPhone_1],
		   [ContactPhone_2],
		   [NextOfKinID],
		   [IsFollowUp]
	FROM Patient
	WHERE IDpatient = @IDPatient
END

GO
CREATE PROC InsertProffessionDetails
	@Occupation nvarchar(50),
	@GrossAnnualIncome int
AS
BEGIN
	INSERT INTO [ProfessionDetails]
           ([Occupation], [GrossAnnualIncome])
    VALUES
           (@Occupation, @GrossAnnualIncome)
	
	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC GetProffessionDetails
	@IDProffesionDetails int
AS
BEGIN
	SELECT [Occupation],
		   [GrossAnnualIncome]
	FROM [ProfessionDetails]
	WHERE [IDProfessionDetails] = @IDProffesionDetails
END


GO
CREATE PROC InsertPersonalDetails
	@MaritalStatus nvarchar(30)
   ,@NumberOfDependents nvarchar(10)
   ,@Height nvarchar(10)
   ,@Weigth nvarchar(10)
   ,@BloodType nvarchar(10)
AS
BEGIN
	INSERT INTO [dbo].[PersonalDetails]
		([MaritalStatus]
		,[NumberOfDependents]
		,[Height]
		,[Weight]
		,[BloodType])
    VALUES
		(@MaritalStatus
		,@NumberOfDependents
		,@Height
		,@Weigth
		,@BloodType)

	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC GetPersonalDetails
	@IDPersonalDetails int
AS
BEGIN
	SELECT [MaritalStatus],
		   [NumberOfDependents],
		   [Height],
		   [Weight],
		   [BloodType]
	FROM [dbo].[PersonalDetails]
	WHERE [IDpersonalDetails] = @IDPersonalDetails
END

GO
CREATE PROC InsertImportantMedicalComplaints
	@Diabetic bit,
	@Hypertensive bit,
    @CardiacCondition nvarchar(50),
    @DigestiveCondition nvarchar(50),
	@OrthopedicCondition nvarchar(50),
	@MuscularCondition nvarchar(50),
	@NeurogicalCondition nvarchar(50),
	@KnownAllergies nvarchar(200),
	@KnownReactionToSpecificDrugs nvarchar(200),
	@MajorSurgeries nvarchar(200)
AS
BEGIN
	INSERT INTO [dbo].[ImportantMedicalComplaints]
		       ([Diabetic]
			   ,[Hypertensive]
			   ,[CardiacCondition]
               ,[DigestiveCondition]
               ,[OrthopedicCondition]
			   ,[MuscularCondition]
               ,[NeurogicalCondition]
               ,[KnownAllergies]
               ,[KnownReactionToSpecificDrugs]
               ,[MajorSurgeries])
    VALUES
          (@Diabetic
          ,@Hypertensive
		  ,@CardiacCondition
		  ,@DigestiveCondition
		  ,@OrthopedicCondition
		  ,@MuscularCondition
		  ,@NeurogicalCondition
          ,@KnownAllergies
		  ,@KnownReactionToSpecificDrugs
		  ,@MajorSurgeries)

	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC GetImportantMedicalComplaints
	@IDImportantMedicalComplaints int
AS
BEGIN
	SELECT [Diabetic]
		  ,[Hypertensive]
		  ,[CardiacCondition]
          ,[DigestiveCondition]
          ,[OrthopedicCondition]
		  ,[MuscularCondition]
          ,[NeurogicalCondition]
          ,[KnownAllergies]
          ,[KnownReactionToSpecificDrugs]
          ,[MajorSurgeries]
	FROM [dbo].[ImportantMedicalComplaints]
	WHERE [IDimportantMedicalComplaints] = @IDImportantMedicalComplaints
END

GO
CREATE PROC InsertBasicComplaints
	@StatementOfComplaint nvarchar(200),
	@HistoryOfPreviousTreatment	nvarchar(2000),
	@PhysicianOrHospital	nvarchar(20)
AS
BEGIN
	INSERT INTO [dbo].[BasicComplaints]
		       ([StatementOfComplaint]
			   ,[HistoryOfPreviousTreatment]
			   ,[PhysicianOrHospital])
     VALUES
           (@StatementOfComplaint
		   ,@HistoryOfPreviousTreatment
		   ,@PhysicianOrHospital)
	
	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC GetBasicComplaints
	@IDBasicComplaints int
AS
BEGIN
	SELECT [StatementOfComplaint]
		  ,[HistoryOfPreviousTreatment]
		  ,[PhysicianOrHospital]
	FROM [dbo].[BasicComplaints]
	WHERE [IDBasicComplaints] = @IDBasicComplaints
END

GO
CREATE PROC InsertLifestyle
	@Smoker bit,
	@AverageNoOfCigarettes int,
	@Alcoholic bit,
	@AverageNoOfDrinks int,
	@UseStimulants nvarchar(200),
	@ConsumptionOfCoffeeAndTea int,
	@ConsumptionOfSoftDrinks int,
	@HaveRegularMeals bit,
	@HomeFood bit,
	@Vegetarian bit
AS
BEGIN
INSERT INTO [dbo].[Lifestyle]
           ([Smoker]
           ,[AverageNoOfCigarettes]
           ,[Alcoholic]
           ,[AverageNoOfDrinks]
           ,[UseStimulants]
           ,[ConsumptionOfCoffeeAndTea]
           ,[ConsumptionOfSoftDrinks]
           ,[HaveRegularMeals]
           ,[HomeFood]
           ,[Vegetarian])
     VALUES
           (@Smoker
		   ,@AverageNoOfCigarettes
		   ,@Alcoholic
		   ,@AverageNoOfDrinks
		   ,@UseStimulants
		   ,@ConsumptionOfCoffeeAndTea
		   ,@ConsumptionOfSoftDrinks
		   ,@HaveRegularMeals
		   ,@HomeFood
		   ,@Vegetarian)

	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC GetLifestyle
	 @IDLifestyle int
AS
BEGIN
	SELECT  [Smoker]
           ,[AverageNoOfCigarettes]
           ,[Alcoholic]
           ,[AverageNoOfDrinks]
           ,[UseStimulants]
           ,[ConsumptionOfCoffeeAndTea]
           ,[ConsumptionOfSoftDrinks]
           ,[HaveRegularMeals]
           ,[HomeFood]
           ,[Vegetarian]
	FROM [dbo].[Lifestyle]
	WHERE [IDlifestyle] = @IDLifestyle
END

GO
CREATE PROC InsertPatientFull
    @PatientID int
   ,@DateOfBirth date
   ,@PermanentAddressID int
   ,@PresentAddressID int
   ,@PersonalDetailsID int
   ,@ProfessionDetailsID int
   ,@LifestyleID int
   ,@BasicComplaintsID int
   ,@ImportantMedicalComplaintsID int
   ,@ContactDetailsContactID int
AS
BEGIN
	INSERT INTO [dbo].[PatientFull]
			   ([PatientID]
			   ,[DateOfBirth]
			   ,[PermanentAdressID]
			   ,[PresentAdressID]
			   ,[PersonalDetailsID]
			   ,[ProfessionDetailsID]
			   ,[LifestyleID]
			   ,[BasicComplaintsID]
			   ,[ImportantMedicalComplaintsID]
			   ,[ContactDetailsContactID])
	VALUES
	      (@PatientID
		  ,@DateOfBirth
		  ,@PermanentAddressID
		  ,@PresentAddressID
		  ,@PersonalDetailsID
		  ,@ProfessionDetailsID
		  ,@LifestyleID
		  ,@BasicComplaintsID
		  ,@ImportantMedicalComplaintsID
		  ,@ContactDetailsContactID)

	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC GetPatientFull
	@IDPatientFull int
AS
BEGIN
	SELECT [DateOfBirth]
	      ,[PatientID]
	      ,[PermanentAdressID]
		  ,[PresentAdressID]
		  ,[PersonalDetailsID]
		  ,[ProfessionDetailsID]
		  ,[LifestyleID]
		  ,[BasicComplaintsID]
		  ,[ImportantMedicalComplaintsID]
		  ,[ContactDetailsContactID]
	FROM [dbo].[PatientFull]
	WHERE [IDPatientFull] = @IDPatientFull
END

GO
CREATE PROC GetAllPatients
AS
BEGIN
	SELECT [IDPatientFull]
	      ,[DateOfBirth]
		  ,[PatientID]
	      ,[PermanentAdressID]
		  ,[PresentAdressID]
		  ,[PersonalDetailsID]
		  ,[ProfessionDetailsID]
		  ,[LifestyleID]
		  ,[BasicComplaintsID]
		  ,[ImportantMedicalComplaintsID]
		  ,[ContactDetailsContactID]
	FROM [dbo].[PatientFull]
END
SELECT * FROM PatientFull
SELECT * FROM Patient
GO
CREATE PROC UpdatePatientFull
	@PatientFullID int
   ,@DateOfBirth date
AS
BEGIN
	UPDATE [dbo].[PatientFull]
	SET DateOfBirth = @DateOfBirth
	WHERE [dbo].[PatientFull].IDPatientFull = @PatientFullID
END

GO
CREATE PROC UpdatePatientShort
	 @PatientShordID int
	,@PatientShortName nvarchar(50)
	,@PatientShortSurname nvarchar(50)
	,@PatientShortMiddlename nvarchar(50)
	,@PatientShortSex nvarchar(1)
	,@PatientShortSoC nvarchar(1000)
	,@PatientShortIsFollowUp bit
	,@PatientShortPhone1 nvarchar(25)
	,@PatientShortPhone2 nvarchar(25)
AS
BEGIN
	UPDATE [dbo].[Patient]
	SET [Name] = @PatientShortName
	   ,Surname = @PatientShortSurname
	   ,Middlename = @PatientShortMiddlename
	   ,Sex = @PatientShortSex
	   ,StatementOfComplaint = @PatientShortSoC
	   ,IsFollowUp = @PatientShortIsFollowUp
	   ,ContactPhone_1 = @PatientShortPhone1
	   ,ContactPhone_2 = @PatientShortPhone2
	WHERE [dbo].[Patient].IDpatient = @PatientShordID
END

GO
CREATE PROC UpdatePersonalDetails
	 @PersonalDetailsID int
	,@MaritalStatus nvarchar(10)
	,@NumberOfDependents nvarchar(10)
	,@BloodType nvarchar(10)
	,@Height nvarchar(10)
	,@Weight nvarchar(10)
AS
BEGIN
	UPDATE [dbo].[PersonalDetails]
	SET MaritalStatus = @MaritalStatus
	   ,NumberOfDependents = @NumberOfDependents
	   ,BloodType = @BloodType
	   ,Height = @Height
	   ,[Weight] = @Weight
	WHERE [dbo].[PersonalDetails].IDpersonalDetails = @PersonalDetailsID
END

GO
CREATE PROC UpdateProffessionDetails
	 @ProffessionDetailsID int
    ,@Occupation nvarchar(30)
	,@Income int
AS
BEGIN
	UPDATE [dbo].[ProfessionDetails]
	SET Occupation = @Occupation
	   ,GrossAnnualIncome = @Income
	WHERE [dbo].[ProfessionDetails].IDProfessionDetails = @ProffessionDetailsID
END

GO
CREATE PROC UpdateLifestyle
	@LifestyleID int
   ,@IsSmoker bit
   ,@NoOfCigarettes int
   ,@IsAlcoholic bit
   ,@NoOfDrinks int
   ,@Stimulants nvarchar(100)
   ,@ConsumptionCoffee int
   ,@ConsumptionSoft int
   ,@HaveRegularMeals bit
   ,@EatsHomeFood bit
   ,@IsVegetarian bit
AS
BEGIN
UPDATE [dbo].[Lifestyle]
	SET Smoker = @IsSmoker
	   ,AverageNoOfCigarettes = @NoOfCigarettes
	   ,Alcoholic = @IsAlcoholic
	   ,AverageNoOfDrinks = @NoOfDrinks
	   ,UseStimulants = @Stimulants
	   ,ConsumptionOfCoffeeAndTea = @ConsumptionCoffee
	   ,ConsumptionOfSoftDrinks = @ConsumptionSoft
	   ,HaveRegularMeals = @HaveRegularMeals
	   ,HomeFood = @EatsHomeFood
	   ,Vegetarian = @IsVegetarian
	WHERE [dbo].[Lifestyle].IDlifestyle = @LifestyleID
END

GO
CREATE PROC UpdateBasicComplaints
	@BasicComplaintsID int
   ,@SoC nvarchar(200)
   ,@TreatmentHistory nvarchar(2000)
   ,@PhysicianOrHospital nvarchar(20)
AS
BEGIN
	UPDATE [dbo].[BasicComplaints]
	SET StatementOfComplaint = @SoC
	   ,HistoryOfPreviousTreatment = @TreatmentHistory
	   ,PhysicianOrHospital = @PhysicianOrHospital
	WHERE [dbo].[BasicComplaints].IDBasicComplaints = @BasicComplaintsID
END

GO
CREATE PROC UpdateImportantMedicalComplaints
	@MedicalComplaintsID int
   ,@IsDiabetic bit
   ,@IsHypertensive bit
   ,@CardiacCondition nvarchar(50)
   ,@OrthopedicCondition nvarchar(50)
   ,@DigestiveCondition nvarchar(50)
   ,@MuscularCondition nvarchar(50)
   ,@NeurologicalCondition nvarchar(50)
   ,@KnownAllergies nvarchar(50)
   ,@ReactionToDrugs nvarchar(50)
   ,@MajorSurgeries nvarchar(200)
AS
BEGIN
	UPDATE [dbo].[ImportantMedicalComplaints]
	SET Diabetic = @IsDiabetic
	   ,Hypertensive = @IsHypertensive
	   ,CardiacCondition = @CardiacCondition
	   ,DigestiveCondition = @DigestiveCondition
	   ,OrthopedicCondition = @OrthopedicCondition
	   ,MuscularCondition = @MuscularCondition
	   ,NeurogicalCondition = @NeurologicalCondition
	   ,KnownAllergies = @KnownAllergies
	   ,KnownReactionToSpecificDrugs = @ReactionToDrugs
	   ,MajorSurgeries = @MajorSurgeries
	WHERE [dbo].[ImportantMedicalComplaints].IDimportantMedicalComplaints = @MedicalComplaintsID
END


GO
CREATE PROC GetPatientFullFromIDPatient
	@IDPatient int
AS
BEGIN
	SELECT *
	FROM [dbo].[PatientFull]
	WHERE IDPatientFull = @IDPatient
END

GO
CREATE PROC InsertBill
	@PaymentMethod nvarchar(50)
   ,@PatientFullID int
   ,@BillDate date
   ,@BillTime time
AS
BEGIN
INSERT INTO [dbo].[Bill]
           ([PaymentMethod]
           ,[PatientFullID]
		   ,[BillDate]
		   ,[BillTime])
	VALUES (@PaymentMethod
		   ,@PatientFullID
		   ,@BillDate
		   ,@BillTime)

	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC GetBill
	@IDBill int
AS
BEGIN
	SELECT [PaymentMethod]
          ,[PatientFullID]
		  ,[BillDate]
		  ,[BillTime]
	FROM [dbo].[Bill]
	WHERE [IDBill] = @IDBill
END

GO
CREATE PROC GetAllBills
AS
BEGIN
	SELECT [IDBill]
		  ,[PaymentMethod]
          ,[PatientFullID]
		  ,[BillDate]
		  ,[BillTime]
	FROM [dbo].[Bill]
END

GO
CREATE PROC InsertAccountItem
	@ItemName nvarchar(50), 
	@ItemPrice float,
	@ItemQuantity int,
	@BillID	int
AS
BEGIN
	INSERT INTO [dbo].[AccountItem]
		       ([ItemName]
			   ,[ItemPrice]
			   ,[ItemQuantity]
			   ,[BillID])
     VALUES
           (@ItemName
		   ,@ItemPrice
		   ,@ItemQuantity
		   ,@BillID)

	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC GetAccountItem
	@IDAccountItem int
AS
BEGIN
	SELECT [ItemName]
		  ,[ItemPrice]
		  ,[ItemQuantity]
		  ,[BillID]
	FROM [dbo].[AccountItem]
	WHERE [IDAccountItem] = @IDAccountItem
END

GO
CREATE PROC GetAccountItemsForBill
	@BillID int
AS
BEGIN
	SELECT [IDAccountItem]
		  ,[ItemName]
		  ,[ItemQuantity]
		  ,[BillID]
		  ,[ItemPrice]
	FROM [dbo].[AccountItem]
	WHERE [dbo].[AccountItem].BillID = @BillID
END

GO
CREATE PROC InsertAppointment
	@Date date
   ,@StartTime time
   ,@EndTime time
   ,@PatientFullID int
   ,@DoctorID int
   ,@AppointmentSummary nvarchar(500)
   ,@Tests nvarchar(500)
   ,@Medicine nvarchar(500)
   ,@Treatment nvarchar(500)
AS
BEGIN
	INSERT INTO [dbo].[Appointment]
	(DateOfAppointment
	,TimeOfAppointmentStart
	,TimeOfAppointmentEnd
	,PatientFullID
	,DoctorID
	,AppointmentSummary
	,OrderedTests
	,PrescribedMedicine
	,OrderedTreatment)
	VALUES
	(@Date
	,@StartTime
	,@EndTime
	,@PatientFullID
	,@DoctorID
	,@AppointmentSummary
	,@Tests
	,@Medicine
	,@Treatment)

	SELECT SCOPE_IDENTITY()
END

GO
CREATE PROC UpdateAppointment
	@IDAppointment int
   ,@Date date
   ,@StartTime time
   ,@EndTime time
   ,@PatientFullID int
   ,@DoctorID int
   ,@AppointmentSummary nvarchar(500)
   ,@Tests nvarchar(500)
   ,@Medicine nvarchar(500)
   ,@Treatment nvarchar(500)
AS
BEGIN
	UPDATE [dbo].[Appointment]
	SET DateOfAppointment = @Date
	   ,TimeOfAppointmentStart = @StartTime
	   ,TimeOfAppointmentEnd = @EndTime
	   ,PatientFullID = @PatientFullID
	   ,DoctorID = @DoctorID
	   ,AppointmentSummary = @AppointmentSummary
	   ,OrderedTests = @Tests
	   ,PrescribedMedicine = @Medicine
	   ,OrderedTreatment = @Treatment
	WHERE [dbo].[Appointment].IDAppointment = @IDAppointment
END

GO
CREATE PROC GetAllAppointments
AS
BEGIN
	SELECT IDAppointment
	      ,DateOfAppointment
		  ,TimeOfAppointmentStart
		  ,TimeOfAppointmentEnd
		  ,PatientFullID
		  ,DoctorID
		  ,AppointmentSummary
		  ,OrderedTests
		  ,PrescribedMedicine
		  ,OrderedTreatment
	FROM [dbo].[Appointment]
END

GO
CREATE PROC GetAppointmentByID
	@IDAppointment int
AS
BEGIN
	SELECT DateOfAppointment
		  ,TimeOfAppointmentStart
		  ,TimeOfAppointmentEnd
		  ,PatientFullID
		  ,DoctorID
		  ,AppointmentSummary
		  ,OrderedTests
		  ,PrescribedMedicine
		  ,OrderedTreatment
	FROM [dbo].[Appointment]
	WHERE IDAppointment = @IDAppointment
END

SELECT * FROM PatientFull
SELECT * FROM Patient
SELECT * FROM NextOfKin
SELECT * FROM ContactDetailsContact
SELECT * FROM ContactDetailsAddress

SELECT * FROM Doctor
SELECT * FROM Appointment
SELECT * FROM ContactDetailsAddress
DELETE FROM ContactDetailsContact

SELECT * FROM ContactDetailsAddress
DELETE FROM ContactDetailsAddress

SELECT * FROM Patient
SELECT * FROM Appointment

SELECT * FROM PersonalDetails
SELECT * FROM PatientFull
SELECT * FROM Patient
SELECT * FROM NextOfKin
SELECT * FROM ContactDetailsContact
SELECT * FROM ContactDetailsAddress

DELETE From PersonalDetails
DELETE FROM Patient
DELETE FROM NextOfKin
DELETE FROM ContactDetailsContact WHERE IDContactDetailsContact > 15
DELETE FROM ContactDetailsAddress WHERE IDContactDetailsAddress > 3

SELECT * FROM Appointment
SELECT * FROM Bill
SELECT * FROM AccountItem