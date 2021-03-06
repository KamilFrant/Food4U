INSERT INTO
    dish(id, price, name, description, ingredients)
VALUES
    (1, 21.21, 'Pizza Domowa', 'Pizza Domowa robiona poza domem.',
     'ser, sos pomidorowy, pieczarki, szynka'),
    (2, 22.22, 'Pizza Hawajska', 'Pizza Hawajska to nie pizza.',
     'ser, sos pomidorowy, ananas, szynka'),
    (3, 23.23, 'Pizza Diabelska', 'Pizza ostra jak nóż.',
     'ser, sos pomidorowy, salami, czosnek, pepperoni, pieczarki, jalapeno, habanero, piri-piri, pieprz kajeński'),
    (4, 24.24, 'Hamburger Classic', 'Klasyczny burger.',
     'wołowina 200g, ser, sałata, pomidor, ketchup'),
    (5, 25.25, 'Burger Czeski Zwyrol','Burger robiony specjalnie przez naszego Czeskiego kucharza.',
     'wołowina 200g, smażony panierowany ser, sałata, pomidor, bekon, cebula, pikle, majonez parmezanowy, sos BBQ'),
    (6, 26.26, 'Burger Italian', 'Burger prosto z Włoch.',
     'wołowina 200g, grillowana spinata, mozzarella fior di latte, rukola, sałata, pesto, pomidor, majonez parmezanowy'),
    (7, 27.27, 'Spaghetti Bolognese', 'Prawdziwe Włoskie Spaghetti Bolognese.',
     'mięso mielone, sos pomidorowy, ser'),
    (8, 28.28, 'Spaghetti Carbonara', 'Prawdziwe Włoskie Spaghetti Carbonara.',
     'boczek, sos śmietanowy, cebula, pieczarki'),
    (9, 29.29, 'Spaghetti alla Spinacio', 'Prawdziwe Włoskie Spaghetti alla Spinacio.',
     'szpinak, cebula, czosnek, sos śmietanowy');


INSERT INTO
    client_order(id, address, phone_number, status)
VALUES
    (1, 'Poniatowskiego 11/1, Lublin 20-004', '551111252', 'NEW'),
    (2, 'Lubowicza 22/1, Lublin 20-003', '684523214', 'NEW'),
    (3, 'Sienkiewicza 34, Lublin 20-002', '747123654', 'NEW'),
    (4, 'Polna 2, Lublin 20-007', '474121363', 'NEW'),
    (5, '3 Maja 3/3, Lublin 20-006', '852369741', 'IN_PREPARATION'),
    (6, 'Niepodległości 42/13, Lublin 20-003', '123654789', 'IN_PREPARATION'),
    (7, 'Racławicka 11/1, Lublin 20-002', '774411225', 'IN_PREPARATION'),
    (8, 'Łęczyńska 22/6, Lublin 20-008', '885664227', 'ON_THE_WAY'),
    (9, 'Zamojska 74/1, Lublin 20-001', '514726598', 'ON_THE_WAY'),
    (10, 'Długa 54, Lublin 20-003', '556554211', 'DELIVERED'),
    (11, 'Hutnicza 31/3, Lublin 20-003', '547125439', 'DELIVERED'),
    (12, 'Głęboka 8/15, Lublin 20-002', '660330880', 'DELIVERED');

INSERT INTO
    order_dish (order_id, dish_id)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 4),
    (2, 5),
    (2, 6),
    (3, 7),
    (3, 8),
    (3, 9),
    (4, 1),
    (4, 2),
    (4, 3),
    (5, 4),
    (5, 5),
    (5, 6),
    (6, 7),
    (6, 8),
    (6, 9),
    (7, 1),
    (7, 2),
    (7, 3),
    (8, 4),
    (8, 5),
    (8, 6),
    (9, 7),
    (9, 8),
    (9, 9),
    (10, 1),
    (10, 2),
    (10, 3),
    (11, 4),
    (11, 5),
    (11, 6),
    (12, 7),
    (12, 8),
    (12, 9);