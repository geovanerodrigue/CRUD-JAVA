/**
 * confirmação de exclusão
 */
 
 function confirmar(id){
	let resposta = confirm("Deseja excluir este Cliente?")
	if(resposta === true){
		//alert(id)
		window.location.href = "delete?id=" + id
	}
}