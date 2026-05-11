import { Component, OnInit } from '@angular/core';
import { Client } from '../../models/client.model';
import { ClientService } from '../../services/client.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html'
})
export class ClientsComponent implements OnInit {

  clients: Client[] = [];
  newClient: Client = { nom: '', email: '' };
  showForm = false;

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {
    this.loadClients();
  }

  loadClients(): void {
    this.clientService.getAll().subscribe(data => this.clients = data);
  }

  saveClient(): void {
    this.clientService.save(this.newClient).subscribe(() => {
      this.loadClients();
      this.newClient = { nom: '', email: '' };
      this.showForm = false;
    });
  }

  deleteClient(id: number): void {
    this.clientService.delete(id).subscribe(() => this.loadClients());
  }
}
