
//Script para preencher o pop-up quando clica no editar
	$('#editModal').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget);
		var id = button.data('id');
		var nome = button.data('nome');
		var casos = button.data('casos');
		
		var cpf = button.data('cpf');
		var cep = button.data('cep');
		
		var modal = $(this);

		// Preenche os campos
		modal.find('#Id').val(id);
		modal.find('#nome').val(nome);
		modal.find('#numeroCasos').val(casos);
		
		modal.find('#cpf').val(cpf);
		modal.find('#cep').val(cep);
	});