--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

-- Started on 2017-04-10 21:28:19

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2160 (class 1262 OID 24658)
-- Name: DataBaseA; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "DataBaseA" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE "DataBaseA" OWNER TO postgres;

\connect "DataBaseA"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 24661)
-- Name: ev_country; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ev_country (
    id integer NOT NULL,
    description text NOT NULL
);


ALTER TABLE ev_country OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 24659)
-- Name: EV_COUNTRY_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "EV_COUNTRY_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "EV_COUNTRY_ID_seq" OWNER TO postgres;

--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 185
-- Name: EV_COUNTRY_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "EV_COUNTRY_ID_seq" OWNED BY ev_country.id;


--
-- TOC entry 188 (class 1259 OID 24672)
-- Name: ev_phone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ev_phone (
    id integer NOT NULL,
    phone text NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE ev_phone OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 24670)
-- Name: EV_PHONE_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "EV_PHONE_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "EV_PHONE_ID_seq" OWNER TO postgres;

--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 187
-- Name: EV_PHONE_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "EV_PHONE_ID_seq" OWNED BY ev_phone.id;


--
-- TOC entry 190 (class 1259 OID 24683)
-- Name: ev_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ev_user (
    id integer NOT NULL,
    name text,
    country_id integer
);


ALTER TABLE ev_user OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 24681)
-- Name: EV_USER_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "EV_USER_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "EV_USER_ID_seq" OWNER TO postgres;

--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 189
-- Name: EV_USER_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "EV_USER_ID_seq" OWNED BY ev_user.id;


--
-- TOC entry 191 (class 1259 OID 24690)
-- Name: ev_known; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ev_known (
    user_id integer NOT NULL,
    known_id integer NOT NULL
);


ALTER TABLE ev_known OWNER TO postgres;

--
-- TOC entry 2020 (class 2604 OID 24664)
-- Name: ev_country id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ev_country ALTER COLUMN id SET DEFAULT nextval('"EV_COUNTRY_ID_seq"'::regclass);


--
-- TOC entry 2021 (class 2604 OID 24675)
-- Name: ev_phone id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ev_phone ALTER COLUMN id SET DEFAULT nextval('"EV_PHONE_ID_seq"'::regclass);


--
-- TOC entry 2022 (class 2604 OID 24686)
-- Name: ev_user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ev_user ALTER COLUMN id SET DEFAULT nextval('"EV_USER_ID_seq"'::regclass);


--
-- TOC entry 2024 (class 2606 OID 24669)
-- Name: ev_country EV_COUNTRY_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ev_country
    ADD CONSTRAINT "EV_COUNTRY_pkey" PRIMARY KEY (id);


--
-- TOC entry 2032 (class 2606 OID 24694)
-- Name: ev_known EV_KNOWN_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ev_known
    ADD CONSTRAINT "EV_KNOWN_pkey" PRIMARY KEY (user_id, known_id);


--
-- TOC entry 2026 (class 2606 OID 24680)
-- Name: ev_phone EV_PHONE_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ev_phone
    ADD CONSTRAINT "EV_PHONE_pkey" PRIMARY KEY (id);


--
-- TOC entry 2029 (class 2606 OID 24700)
-- Name: ev_user EV_USER_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ev_user
    ADD CONSTRAINT "EV_USER_pkey" PRIMARY KEY (id);


--
-- TOC entry 2030 (class 1259 OID 24717)
-- Name: fki_cuntry; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_cuntry ON ev_user USING btree (country_id);


--
-- TOC entry 2033 (class 1259 OID 24734)
-- Name: fki_k_know; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_k_know ON ev_known USING btree (known_id);


--
-- TOC entry 2034 (class 1259 OID 24728)
-- Name: fki_k_user; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_k_user ON ev_known USING btree (user_id);


--
-- TOC entry 2027 (class 1259 OID 24706)
-- Name: fki_user; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_user ON ev_phone USING btree (user_id);


--
-- TOC entry 2036 (class 2606 OID 24712)
-- Name: ev_user cuntry; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ev_user
    ADD CONSTRAINT cuntry FOREIGN KEY (country_id) REFERENCES ev_country(id);


--
-- TOC entry 2038 (class 2606 OID 24729)
-- Name: ev_known k_know; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ev_known
    ADD CONSTRAINT k_know FOREIGN KEY (known_id) REFERENCES ev_user(id);


--
-- TOC entry 2037 (class 2606 OID 24723)
-- Name: ev_known k_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ev_known
    ADD CONSTRAINT k_user FOREIGN KEY (user_id) REFERENCES ev_user(id);


--
-- TOC entry 2035 (class 2606 OID 24701)
-- Name: ev_phone user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ev_phone
    ADD CONSTRAINT "user" FOREIGN KEY (user_id) REFERENCES ev_user(id);


-- Completed on 2017-04-10 21:28:22

--
-- PostgreSQL database dump complete
--

