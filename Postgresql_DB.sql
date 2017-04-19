CREATE TABLE public.ev_country
(
    id serial,
    description text NOT NULL,
    CONSTRAINT "EV_COUNTRY_pkey" PRIMARY KEY (id)
);


CREATE TABLE public.ev_user
(
    id serial,
    name text ,
    country_id integer,
    CONSTRAINT "EV_USER_pkey" PRIMARY KEY (id),
    CONSTRAINT cuntry FOREIGN KEY (country_id)
        REFERENCES public.ev_country (id)
);


CREATE TABLE public.ev_phone
(
    id serial,
    phone text,
    user_id integer NOT NULL,
    CONSTRAINT "EV_PHONE_pkey" PRIMARY KEY (id),
    CONSTRAINT "user" FOREIGN KEY (user_id)
        REFERENCES public.ev_user (id) 
);



CREATE TABLE public.ev_known
(
    user_id integer NOT NULL,
    known_id integer NOT NULL,
    CONSTRAINT "EV_KNOWN_pkey" PRIMARY KEY (user_id, known_id),
    CONSTRAINT k_know FOREIGN KEY (known_id)
        REFERENCES public.ev_user (id),
    CONSTRAINT k_user FOREIGN KEY (user_id)
        REFERENCES public.ev_user (id)
);


    INSERT INTO public.ev_country(
     description)
    VALUES ( 'US');

    INSERT INTO public.ev_country(
     description)
    VALUES ( 'UK');