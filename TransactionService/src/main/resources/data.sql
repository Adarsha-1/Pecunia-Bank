INSERT INTO pecunia_bank_account (account_id,aadhar,amount,IFSC,branch_id,status,account_type) VALUES (12345,123,10000.00,'gfsert',10,'open','savings');

INSERT INTO pecunia_bank_account (account_id,aadhar,amount,IFSC,branch_id,status,account_type) VALUES (12346,123,10000.00,'gfsert',10,'open','savings');

INSERT INTO pecunia_bank_transaction (transaction_id,account_id,transaction_type,transaction_amount,balance,transaction_date,transaction_status) VALUES (11111,12345,'credit',100.00,10052.0,'2020-01-01','sucess');
INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(123,2000000001,'DEDIT',5500.00,TO_DATE( '12-DEC-2019', 'DD-MON-YYYY' ),'DONE',89000.00);
INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(124,2000000001,'CREDIT',2000.00,TO_DATE( '30-JAN-2020', 'DD-MON-YYYY' ),'DONE',94000.00);
INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(125,2000000001,'DEBIT',5000.00,TO_DATE( '14-JUL-2020', 'DD-MON-YYYY' ),'DONE',89000.00);

INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(126,2000000021,'DEBIT',500.00,TO_DATE( '12-NOV-2019', 'DD-MON-YYYY' ),'DONE',68326.02);
INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(127,2000000021,'CREDIT',1455.00,TO_DATE( '02-DEC-2019', 'DD-MON-YYYY' ),'DONE',69781.02);
INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(128,2000000021,'DEBIT',3000.00,TO_DATE( '22-FEB-2020', 'DD-MON-YYYY' ),'DONE',66781.02);
INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(129,2000000021,'DEBIT',2550.00,TO_DATE( '12-JUN-2020', 'DD-MON-YYYY' ),'DONE',64321.02);
INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(130,2000000021,'CREDIT',10000.00,TO_DATE( '12-SEP-2020', 'DD-MON-YYYY' ),'DONE',74321.02);


INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(131,2000000061,'DEBIT',5500.00,TO_DATE( '13-DEC-2019', 'DD-MON-YYYY' ),'DONE',96758.00);
INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(132,2000000061,'DEBIT',5500.00,TO_DATE( '12-MAR-2020', 'DD-MON-YYYY' ),'DONE',91258.00);
INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(133,2000000061,'DEBIT',5500.00,TO_DATE( '12-JUL-2020', 'DD-MON-YYYY' ),'DONE',85758.00);
INSERT INTO PECUNIA_BANK_TRANSACTION(TRANSACTION_ID,ACCOUNT_ID,TRANSACTION_TYPE,TRANSACTION_AMOUNT,TRANSACTION_DATE,TRANSACTION_STATUS,BALANCE) VALUES(134,2000000061,'CREDIT',5500.00,TO_DATE( '12-AUG-2020', 'DD-MON-YYYY' ),'DONE',91258.00);