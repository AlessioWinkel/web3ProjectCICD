CREATE SCHEMA groep301;


CREATE SEQUENCE groep301.project_id_seq;

GRANT ALL ON SEQUENCE groep301.project_id_seq TO local_r0877579;

CREATE TABLE groep301.project
(   projectid integer NOT NULL DEFAULT nextval('groep301.project_id_seq'::regclass),
    naam character varying COLLATE pg_catalog."default" NOT NULL,
    team character varying COLLATE pg_catalog."default" NOT NULL,
    start DATE NOT NULL,
    einde DATE,
    CONSTRAINT project_pkey PRIMARY KEY (projectid)
);

GRANT ALL ON TABLE groep301.project TO local_r0877579;

INSERT INTO groep301.project ("projectid","naam","team","start","einde") values (1, 'alessiotest', 'alpha', '22/02/2022',NULL);


-- grant aan teamgenoot
GRANT ALL ON SCHEMA groep301 TO local_r0842359;
GRANT ALL ON SEQUENCE groep301.project_id_seq TO local_r0842359;
GRANT ALL ON TABLE groep301.project TO local_r0842359;

-- grant aan lectoren
GRANT ALL ON SCHEMA groep301 TO local_u0015529;
GRANT ALL ON SEQUENCE groep301.project_id_seq TO local_u0015529;
GRANT ALL ON TABLE groep301.project TO local_u0015529;

GRANT ALL ON SCHEMA groep301 TO local_u0034562;
GRANT ALL ON SEQUENCE groep301.project_id_seq TO local_u0034562;
GRANT ALL ON TABLE groep301.project TO local_u0034562;


