insert into group_optins(id, group_name, description, active) values('e893777a-6be4-4782-a63e-7fe068a2ab74', 'WHATSAPP', 'Grupo de Whatsapp', true);
insert into group_optins(id, group_name, description, active) values('5049fe1e-ac3b-4ad4-8ff8-4532b1ca1292', 'PROGRAMA BETA', 'Programa Beta', true);
insert into group_optins(id, group_name, description, active) values('2fa88e6c-3b74-4975-baa2-23d727116a78', 'E-MAIL', 'Envio de E-mail', true);
insert into group_optins(id, group_name, description, active) values('0ec02fb3-6b03-4e82-b576-7dc78ab97e7e', 'SMS', 'Envio de SMS', true);
insert into group_optins(id, group_name, description, active) values('04458db8-caf4-4220-80df-58cca9f8b8ab', 'LGPD', 'Aceite do Cookie', true);

insert into optins(id, group_id, optins_name) values('48d72d87-6933-43ea-b2d2-62cb598a15c2', 'e893777a-6be4-4782-a63e-7fe068a2ab74', 'Transacional');
insert into optins(id, group_id, optins_name) values('e55efa6f-7cb5-447e-aec8-32cb076772d8', 'e893777a-6be4-4782-a63e-7fe068a2ab74', 'Campanhas Heblon');
insert into optins(id, group_id, optins_name) values('befcceba-12ab-4133-bded-390a7cae902b', 'e893777a-6be4-4782-a63e-7fe068a2ab74', 'Banho&Tosa');
insert into optins(id, group_id, optins_name) values('1c80c9cd-981f-4b4c-9df3-79bcfc65cab9', '5049fe1e-ac3b-4ad4-8ff8-4532b1ca1292', 'Quer participar de um programa beta');
insert into optins(id, group_id, optins_name) values('9b3a17c6-35fc-4360-b17c-2420f311a7e4', '2fa88e6c-3b74-4975-baa2-23d727116a78', 'Transacional');
insert into optins(id, group_id, optins_name) values('ed94c17e-6bab-47d5-a9d3-74c07285812c', '2fa88e6c-3b74-4975-baa2-23d727116a78', 'Campanhas Heblon');
insert into optins(id, group_id, optins_name) values('f67f6e87-4364-44d5-8bec-487af9ff7dff', '2fa88e6c-3b74-4975-baa2-23d727116a78', 'Banho&Tosa');

insert into customer_optins (customer_id, optins_id) values((select id from cdm.customers c where c.email = 'herbertrbarbieri@gmail.com'), '48d72d87-6933-43ea-b2d2-62cb598a15c2')


