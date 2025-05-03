-- V2 Migrations to add Rank column on Register Table

ALTER TABLE tb_register
ADD COLUMN rank VARCHAR(255);