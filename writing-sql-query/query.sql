-- a. Returns the names of all Salesperson that don’t have any order with Samsonic.
SELECT sp."name" FROM Salesperson AS sp
WHERE sp."ID" NOT IN (
		SELECT salesperson_id FROM orders o
		INNER JOIN Customer cus
		ON cus."name" = 'Samsonic'
		AND cus."ID" = o.customer_id
)
-----------------------------------------------------------
--b. Updates the names of Salesperson that have 2 or more orders. It’s necessary to add an ‘*’ in the end of the name.
UPDATE Salesperson as sp  set "name" = sp."name" || '*'
WHERE sp."ID" in (
	SELECT  salesperson_id FROM  orders o
    GROUP BY salesperson_id
    HAVING COUNT(*) >= 2
)
----------------------------------------------------------
--c. Deletes all Ssalesperson that placed orders to the city of Jackson.
CREATE TEMP TABLE jackson_salesperson AS
SELECT salesperson_id FROM orders o
INNER JOIN "Customer" cus
ON cus.city = 'Jackson'
AND cus."ID" = o.customer_id;

DELETE FROM orders
WHERE salesperson_id IN (SELECT salesperson_id FROM jackson_salesperson);

DELETE FROM salesperson
WHERE "ID" IN (SELECT salesperson_id FROM jackson_salesperson);

DROP TABLE jackson_salesperson;
--------------------------------------------------------
--d. The total sales amount for each Salesperson. If the salesperson hasn’t sold anything, show zero.
SELECT sp."name", SUM(CASE WHEN amount IS NOT NULL THEN amount ELSE 0 END) FROM salesperson sp
LEFT JOIN orders o
ON o.salesperson_id = sp."ID"
GROUP BY sp."name"