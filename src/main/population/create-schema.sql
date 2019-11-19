
    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `announcement` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `more_info` varchar(255),
        `text` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `banner` (
       `id` integer not null,
        `version` integer not null,
        `picture` varchar(255),
        `slogan` varchar(255),
        `targeturl` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `challenge` (
       `id` integer not null,
        `version` integer not null,
        `bronze_goal` varchar(255),
        `bronze_reward_amount` double precision,
        `bronze_reward_currency` varchar(255),
        `deadline` datetime(6),
        `description` varchar(255),
        `gold_goal` varchar(255),
        `gold_reward_amount` double precision,
        `gold_reward_currency` varchar(255),
        `silver_goal` varchar(255),
        `silver_reward_amount` double precision,
        `silver_reward_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `commercial_banner` (
       `id` integer not null,
        `version` integer not null,
        `picture` varchar(255),
        `slogan` varchar(255),
        `targeturl` varchar(255),
        `credit_card_number` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `company_record` (
       `id` integer not null,
        `version` integer not null,
        `ceo` varchar(255),
        `description` varchar(255),
        `email` varchar(255),
        `is_inc` bit,
        `name` varchar(255),
        `phone` varchar(255),
        `sector` varchar(255),
        `star_number` integer,
        `website` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `consumer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `customization` (
       `id` integer not null,
        `version` integer not null,
        `activeid` integer,
        `spam_threshold` double precision,
        `spam_words` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `investor` (
       `id` integer not null,
        `version` integer not null,
        `investing_statement` varchar(255),
        `investor_name` varchar(255),
        `sector` varchar(255),
        `stars_number` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `non_commercial_banner` (
       `id` integer not null,
        `version` integer not null,
        `picture` varchar(255),
        `slogan` varchar(255),
        `targeturl` varchar(255),
        `jingle` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `offer` (
       `id` integer not null,
        `version` integer not null,
        `amount_amount` double precision,
        `amount_currency` varchar(255),
        `creation_moment` datetime(6),
        `description_text` varchar(255),
        `limit_date` datetime(6),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `provider` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `request` (
       `id` integer not null,
        `version` integer not null,
        `creation_moment` datetime(6),
        `deadline` datetime(6),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `text` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );

    alter table `customization` 
       add constraint `UK1i2pxu5xiyd2tkwo83784r4l0` unique (`activeid`);

    alter table `offer` 
       add constraint `UKcp4664f36sgqsd0ihmirt0w0` unique (`ticker`);

    alter table `request` 
       add constraint `UKh9syauj4iixf18uts83saik5d` unique (`ticker`);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `consumer` 
       add constraint FK_6cyha9f1wpj0dpbxrrjddrqed 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `provider` 
       add constraint FK_b1gwnjqm6ggy9yuiqm0o4rlmd 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);
