<?php
// Incluindo arquivo de conexão
//session_start();
require 'conexao_foto.php';
 if($_FILES['foto']['name'] == "" || $_FILES['foto']['name'] == null ) {
$id_foto=$_SESSION['foto'];
   
 }else{
// Constantes para tamanho menor de 2 mb da imagem
define('TAMANHO_MAXIMO', (2 * 1024 * 1024));


// Recupera os dados dos campos
$foto = $_FILES['foto'];
$nome = $foto['name'];
$tipo = $foto['type'];
$tamanho = $foto['size'];
$fk_pessoa_id=$_SESSION['id'];
$id_foto;
// Validações básicas
// Formato
if(!preg_match('/^image\/(pjpeg|jpg|jpeg|png|gif|bmp)$/', $tipo))
{
   

$id_foto=$_SESSION['foto'];
    exit;
}

// Tamanho
if ($tamanho > TAMANHO_MAXIMO)
{
    echo "A imagem deve possuir no máximo 2 MB";
    exit;
}

// Transformando foto em dados (binário)

$conteudo = file_get_contents($foto['tmp_name']);
if($_SESSION['foto']==1){
$stmt = $pdo->prepare('INSERT INTO fotos (nome, conteudo, tipo, tamanho) VALUES (:nome, :conteudo, :tipo, :tamanho)');

// Definindo parâmetros
$stmt->bindParam(':nome', $nome, PDO::PARAM_STR);
$stmt->bindParam(':conteudo', $conteudo, PDO::PARAM_LOB);
$stmt->bindParam(':tipo', $tipo, PDO::PARAM_STR);
$stmt->bindParam(':tamanho', $tamanho, PDO::PARAM_INT);
//$stmt->bindParam(':fk_pessoa_id', $fk_pessoa_id, PDO::PARAM_INT);
if($stmt->execute()){
$id_foto=$pdo->lastInsertId();

   }else{
  $_SESSION['msg']="".$stmt->errorInfo();

}
}else{
$stmt = $pdo->prepare('UPDATE fotos SET nome=:nome, conteudo=:conteudo, tipo=:tipo, tamanho=:tamanho
    WHERE id=:id');

// Definindo parâmetros
$stmt->bindParam(':nome', $nome, PDO::PARAM_STR);
$stmt->bindParam(':conteudo', $conteudo, PDO::PARAM_LOB);
$stmt->bindParam(':tipo', $tipo, PDO::PARAM_STR);
$stmt->bindParam(':tamanho', $tamanho, PDO::PARAM_INT);
$stmt->bindParam(':id', $_SESSION['foto'], PDO::PARAM_INT);
$stmt->execute();
$id_foto=$_SESSION['foto'];

}
}
