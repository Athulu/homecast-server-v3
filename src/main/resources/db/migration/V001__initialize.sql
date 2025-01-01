CREATE TABLE public.source
(
    source_id SERIAL PRIMARY KEY NOT NULL,
    mime      VARCHAR(255),
    type      VARCHAR(255)
);

CREATE TABLE public.video_directory
(
    video_directory_id SERIAL PRIMARY KEY NOT NULL,
    path               VARCHAR(255),
    is_enabled         BOOLEAN,
    created_at         TIMESTAMP
);

CREATE TABLE public.image
(
    image_id   SERIAL PRIMARY KEY NOT NULL,
    filename   VARCHAR(255),
    created_at TIMESTAMP,
    video_id   INT                NOT NULL
);

CREATE TABLE public.video
(
    video_id           SERIAL PRIMARY KEY NOT NULL,
    filename           VARCHAR(255),
    title              VARCHAR(255),
    episode            VARCHAR(255),
    subtitle           VARCHAR(255),
    duration           INT,
    created_at         TIMESTAMP,
    last_used_at       TIMESTAMP,
    image_id           INT,
    video_directory_id INT,
    source_id          INT,
    CONSTRAINT fk_video_image_id FOREIGN KEY (image_id) REFERENCES public.image (image_id),
    CONSTRAINT fk_video_video_directory_id FOREIGN KEY (video_directory_id) REFERENCES public.video_directory (video_directory_id),
    CONSTRAINT fk_video_source_id FOREIGN KEY (source_id) REFERENCES public.source (source_id)
);

CREATE TABLE public.setting
(
    property    VARCHAR(255) PRIMARY KEY NOT NULL,
    value       VARCHAR(255),
    description VARCHAR(255)
);