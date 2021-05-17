CREATE TABLE group_optins (
    id uuid NOT NULL,
    group_name varchar(50) NOT NULL,
    description text,
    create_date timestamp default CURRENT_TIMESTAMP,
    update_date timestamp,
    active bool NOT NULL default true,
    CONSTRAINT group_optins_pkey PRIMARY KEY (id)
);

CREATE TABLE optins (
    id uuid NOT NULL,
    group_id uuid NOT NULL,
    optins_name varchar(255),
    description text,
    create_date timestamp default CURRENT_TIMESTAMP,
    update_date timestamp,
    active bool NOT NULL default true,
    CONSTRAINT optins_pkey PRIMARY KEY (id),
    CONSTRAINT group_optins_fk FOREIGN KEY (group_id) REFERENCES group_optins(id)
);


CREATE TABLE customer_optins (
    customer_id uuid NOT NULL,
    optins_id uuid NOT NULL,
    flag_option bool NOT NULL default true,
    create_date timestamp default CURRENT_TIMESTAMP,
    update_date timestamp,
    CONSTRAINT fk_optins_id FOREIGN KEY (optins_id) REFERENCES optins(id),
    CONSTRAINT uk_customer_optins UNIQUE (customer_id, optins_id)
);

CREATE TABLE customer_optins_history (
    customer_id uuid NOT NULL,
    optins_id uuid NOT NULL,
    flag_option bool NOT NULL default true,
    create_date timestamp default CURRENT_TIMESTAMP
);



