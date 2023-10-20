INSERT INTO cuenta (codigo, correo, password, type_usuario) VALUES (1, 'pepito@email.com', '123', 'tipo_usuario_1');

-- Para el segundo registro
INSERT INTO cuenta (codigo, correo, password, type_usuario) VALUES (2, 'juanita@email.com', '234', 'tipo_usuario_2');


-- Otras declaraciones SQL si es necesario


INSERT INTO usuario(codigo,codigo_ciudad,nombre,telefono,url_foto)
VALUES ('1','3','andres','5666','hhhhh');


INSERT INTO usuario(codigo,codigo_ciudad,nombre,telefono,url_foto)
VALUES ('2','3','andres','5666','hhhhh');


INSERT INTO paciente (codigo, fecha_nacimiento, alergias, cedula, codigotipo_sangre,codigoeps)
VALUES
    ('1', '1990-01-01', 'Sin alergias', '24567234', 1, 1);


INSERT INTO paciente (codigo, fecha_nacimiento, alergias, cedula, codigotipo_sangre,codigoeps)
VALUES
    ('2', '1990-01-01', 'Sin alergias', '24567234', 1, 1);
