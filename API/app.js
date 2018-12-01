var express = require('express');
var app = express();
var fs = require("fs");

/**
 * Trae todos los dias ./dias
 */
app.get('/dias', function (req, res) {
   fs.readFile( __dirname + "/" + "clima.json", 'utf8', function (err, data) {
      console.log( data );
      res.end( data );
   });
})

/**
 * Se genera la consulta, trayendo el dia deseado. Se tiene en cuenta que la lista empieza del dia 0,
 * y el archivo json, tiene todos los dias de manera ordenada. 
 * Sino habria que hacer una busqueda en el fuente. 
 * La manera de invocarlo es la siguiente
 * https://../clima?dia=x 
 * donde x es el valor del dia a buscar.
 */
app.get('/clima', function (req, res) {
   // First read existing dia.
   fs.readFile( __dirname + "/" + "clima.json", 'utf8', function (err, data) {
      var dias = JSON.parse( data );
      res.end( JSON.stringify(dias[req.query.dia]));
      console.log("busca parametro " +req.query.dia);
      
   });
})

var server = app.listen(8080, function () {
   var host = server.address().address
   var port = server.address().port
   console.log("Example app listening at http://%s:%s", host, port)
})