create database customer

CREATE TABLE Customer (
	customer_id int identity(1,1) PRIMARY KEY,
    customer_name nvarchar(255)
);

CREATE TABLE Employee (
	employee_id int identity(1,1) PRIMARY KEY,
    employee_name nvarchar(255),
    salary money,
    supervisor_id int,
    FOREIGN KEY (supervisor_id) REFERENCES Employee(employee_id)
);

CREATE TABLE Product (
	product_id int identity(1,1) PRIMARY KEY,
    product_name nvarchar(255),
    list_price money
);

CREATE TABLE Orders (
	order_id int identity(1,1) PRIMARY KEY,
    order_date datetime,
    customer_id int,
    employee_id int,
    total money,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

CREATE TABLE LineItem (
	order_id int,
    product_id int,
    quantity int,
    price money,
    PRIMARY KEY (order_id,product_id),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
);


CREATE FUNCTION computeOrderTotal (@order_id int)
RETURNS money
BEGIN
	DECLARE @total money;
	SET @total = 0;
	SELECT  @total = SUM(price * quantity) FROM lineitem WHERE lineitem.order_id = @order_id;
	RETURN @total;
END 


select dbo.computeOrderTotal(1)


CREATE PROCEDURE addCustomer (@customerName nvarchar(255),  @row int output)
AS
BEGIN
	INSERT INTO Customer (customer_name) VALUES (@customerName);
	SELECT @row = @@ROWCOUNT
END 

declare @row int
Exec dbo.addCustomer @customerName = 'Hay', @row = @row output
select @row



CREATE PROCEDURE deleteCustomer1 ( @customerId int,  @deleteStatus int output )
AS
BEGIN
	BEGIN TRANSACTION;
	BEGIN TRY
		DELETE FROM LineItem WHERE order_Id IN (SELECT order_Id FROM Orders WHERE customer_id = @customerId);
		DELETE FROM Customer WHERE customer_id = @customerId;
		DELETE FROM Orders WHERE customer_id = @customerId;

		select @deleteStatus = 1;
		COMMIT TRANSACTION;
	END TRY
	BEGIN CATCH
		select @deleteStatus = 0;
		ROLLBACK TRANSACTION;
	END CATCH;
END

DECLARE @result INT
SELECT @result=0 
EXECUTE dbo.deleteCustomer1 5, @result output
select @result
