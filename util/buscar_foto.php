<?php

require 'conexao_foto.php';




    // Conectando
  
$id = (int) $_GET['id'];

// Selecionando fotos
$stmt = $pdo->prepare('SELECT conteudo, tipo FROM fotos WHERE id = :id');
$stmt->bindParam(':id', $id, PDO::PARAM_INT);

// Se executado
if ($stmt->execute())
{
    // Alocando foto
    $foto = $stmt->fetchObject();
    
    // Se existir
    if ($foto != null)
    {
        // Definindo tipo do retorno
        header('Content-Type: '. $foto->tipo);
        
        // Retornando conteudo
        echo $foto->conteudo;
    }
}