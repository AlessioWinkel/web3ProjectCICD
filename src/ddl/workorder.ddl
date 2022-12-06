CREATE SEQUENCE groep301.workorder_id_seq;

GRANT ALL ON SEQUENCE groep301.workorder_id_seq TO local_r0877579;

CREATE TABLE groep301.workorder
(   workorder_id integer NOT NULL DEFAULT nextval('groep301.workorder_id_seq'::regclass),
    userid integer NOT NULL,
    username character varying COLLATE pg_catalog."default" NOT NULL,
    userteam character varying COLLATE pg_catalog."default" NOT NULL,
    datum TIMESTAMP NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    description character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT workorder_pkey PRIMARY KEY (workorder_id)
);

GRANT ALL ON TABLE groep301.workorder TO local_r0877579;


-- grant aan teamgenoot
GRANT ALL ON SCHEMA groep301 TO local_r0842359;
GRANT ALL ON SEQUENCE groep301.workorder_id_seq TO local_r0842359;
GRANT ALL ON TABLE groep301.workorder TO local_r0842359;


-- grant aan lectoren
GRANT ALL ON SCHEMA groep301 TO local_u0015529;
GRANT ALL ON SEQUENCE groep301.workorder_id_seq TO local_u0015529;
GRANT ALL ON TABLE groep301.workorder TO local_u0015529;

GRANT ALL ON SCHEMA groep301 TO local_u0034562;
GRANT ALL ON SEQUENCE groep301.workorder_id_seq TO local_u0034562;
GRANT ALL ON TABLE groep301.workorder TO local_u0034562;