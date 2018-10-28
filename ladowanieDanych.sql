use OSK
GO

BULK INSERT dbo.Kurs FROM 'E:\kolizjaOSK\kursy.bulk' WITH (FIELDTERMINATOR=';')
BULK INSERT dbo.Kursant FROM 'E:\kolizjaOSK\kursanci.bulk' WITH (FIELDTERMINATOR=';')
BULK INSERT dbo.Instruktor FROM 'E:\kolizjaOSK\instruktorzy.bulk' WITH (FIELDTERMINATOR=';')
BULK INSERT dbo.Uczenie FROM 'E:\kolizjaOSK\uczenia.bulk' WITH (FIELDTERMINATOR=';')
