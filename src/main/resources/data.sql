
DELETE FROM public.ticket_details;
DELETE FROM public.food_details;
DELETE FROM public.route_details;

insert into public.food_details (id, description, name, price)
values (1, 'Chicken BBQ', 'Chicken BBQ', 100);
insert into public.food_details (id, description, name, price)
values (2, 'Beef BBQ', 'Beef BBQ', 250);
insert into public.food_details (id, description, name, price)
values (3, 'Beef Tehari', 'Beef Tehari', 350);

insert into public.route_details (id, description, name)
values (1, 'Dhaka to khulna', 'DHA-KHU-DHA');
insert into public.route_details (id, description, name)
values (2, 'Dhaka to Barishal', 'DHA-BARI-DHA');
insert into public.route_details (id, description, name)
values (3, 'Dhaka to Kolkata', 'DHA-KOL-DHA');

insert into public.ticket_details (id, flight_date, food_id, route_id, ticket_price)
values (1,'2024-01-01',2,2,500);
insert into public.ticket_details (id, flight_date, food_id, route_id, ticket_price)
values (2,'2024-02-05',2,2,600);
insert into public.ticket_details (id, flight_date, food_id, route_id, ticket_price)
values (3,'2024-01-01',3,1,500);
insert into public.ticket_details (id, flight_date, food_id, route_id, ticket_price)
values (8,'2024-01-10',2,3,500);
