import torch
import torch.nn as nn

def train():
    model = nn.Linear(4,2)

    criterion = torch.nn.MSELoss()
    optimizer = torch.optim.SGD(model.parameters(), lr=0.1)

    for epoch in range(10):
        inputs = torch.Tensor([0.8,0.4,0.4,0.2])
        labels = torch.Tensor([1,0])

        optimizer.zero_grad()

        outputs = model(inputs)

        loss = criterion(outputs, labels)
        print(loss)

        optimizer.step()

        print('epoch {}, loss {}'.format(epoch, loss.item()))

def neuron(input):
  weights = torch.Tensor([0.5, 0.5, 0.5])
  b = torch.Tensor([0.5])
  return torch.add(torch.matmul(input,weights),b)

if __name__ == "__main__":
    train()