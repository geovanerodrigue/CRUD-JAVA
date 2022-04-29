/**
 * 
 */
 
 function validar() {
	let nome = frmPessoas.nome.value
	let email = frmPessoas.email.value
	let cargo = frmPessoas.cargo.value
	
	if (nome === ""){
		alert('Preencha o campo Nome')
		frmPessoas.nome.focus()
		return false
	}else if (email === ""){
				alert('Preencha o campo Email')
		frmPessoas.email.focus()
		return false
	}else if (cargo === ""){
				alert('Preencha o campo Cargo')
		frmPessoas.cargo.focus()
		return false
		}else{
		document.forms["frmPessoas"].submit()
	}
}