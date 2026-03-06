Alter Table USUARIOS
Add
(
    PERFIL  VarChar(10)  not null
);

Update USUARIOS Set PERFIL = "USER";