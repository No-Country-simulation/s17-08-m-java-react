describe('Button insertion and form submission test', () => {
  it('inserta botones, navega y completa el formulario de albañil', () => {
    cy.visit('http://localhost:3000');
    cy.wait(1000); // Espera 10 segundos después de cargar la página inicial

    // Definir el enlace HTML del fontanero
    const plumberLinkHtml = `<a href="/plomero" id="plumber-link">Plomero</a>`;

    // Insertar el enlace en la página
    cy.window().then((win) => {
      const body = win.document.body;
      const div = win.document.createElement('div');
      div.innerHTML = plumberLinkHtml;
      body.appendChild(div);
    });
    cy.wait(1000);

    // Verifica que el enlace haya sido insertado y haz clic
    cy.get('#plumber-link').should('be.visible').and('have.text', 'Plomero').click();
    cy.wait(1000);

    // Verificamos que hemos navegado a la página del plomero
    cy.url().should('include', '/plomero');
    cy.wait(1000);

    // Definir el botón de solicitud de presupuesto
    const budgetRequestHtml = `<a class="bg-blue-500 hover:bg-blue-700 text-white py-2 px-4 rounded-2xl" href="/formulario-albanil">Solicitar presupuesto</a>`;

    // Insertar el botón de solicitud de presupuesto en la página del plomero
    cy.window().then((win) => {
      const body = win.document.body;
      const div = win.document.createElement('div');
      div.innerHTML = budgetRequestHtml;
      body.appendChild(div);
    });
    cy.wait(1000);

    // Verificar que el botón de solicitud de presupuesto se ha insertado y hacer clic
    cy.contains('Solicitar presupuesto').should('be.visible').click();
    cy.wait(1000);

    // Verificar que hemos navegado a la página del formulario de albañil
    cy.url().should('include', '/formulario-albanil');
    cy.wait(1000);

    // Completar el formulario
    cy.get('input[placeholder="Ingresa la categoría"]').type('Albañilería');
    cy.wait(1000);
    cy.get('input[placeholder="Título del servicio"]').type('Reparación de pared');
    cy.wait(1000);
    cy.get('textarea[placeholder="Descripción detallada del servicio"]').type('Necesito reparar una pared con grietas en mi sala de estar');
    cy.wait(1000);
    cy.get('input[placeholder="Ubicación del servicio"]').type('Calle Principal 123, Ciudad');
    cy.wait(1000);
    
    // Para el campo de fecha y hora, usamos una fecha y hora específicas
    const futureDate = new Date();
    futureDate.setDate(futureDate.getDate() + 7); // Una semana en el futuro
    const formattedDate = futureDate.toISOString().slice(0, 16); // Formato YYYY-MM-DDTHH:mm
    cy.get('input[type="datetime-local"]').type(formattedDate);
    
    cy.wait(1000); // Espera después de completar el formulario

    // Enviar el formulario
    cy.contains('Reserva una visita').click();
    cy.wait(1000);

    // Aquí puedes añadir una verificación adicional, como un mensaje de confirmación
    // Por ejemplo:
    // cy.contains('Reserva confirmada').should('be.visible');
  });
});