#Numpy is linear algebra lbrary
import numpy as np
# Matplotlib is a visualizations library 
import matplotlib.pyplot as plt
import torch
import torch.nn as nn
import torch.optim as optim
from torchvision import utils
from torchvision import transforms

batch_size = 4

def load_data():
    transform = transforms.Compose([
        transforms.ToTensor(),
        transforms.Normalize((0.5,0.5,0.5),(0.5,0.5,0.5))
    ])
    trainloader = torch.utils.data.DataLoader(batch_size=batch_size,shuffle=False,num_workers=1)
    return trainloader

def show_image(img):
    img = img / 2 + 0.5     # unnormalize
    npimg = img.numpy()
    plt.imshow(np.transpose(npimg, (1, 2, 0)))
    plt.show()

classes = ('plane', 'car', 'bird', 'cat',
       'deer', 'dog', 'frog', 'horse', 'ship', 'truck')

# get some random training images
dataiter = iter(load_data())
images, labels = dataiter.next()

# show images
show_image(utils.make_grid(images))
# print labels
print(' '.join('%5s' % classes[labels[j]] for j in range(4)))

def train():

    training_data = load_data()
    
    # 2. LOSS AND OPTIMIZER
    
    
    running_loss = 0.0

    for epoch in range(10):
        for i, data in enumerate(training_data, 0):
           
            inputs, labels = data
            #reshape images so they can be fed to a nn.Linear()
            inputs = inputs.view(inputs.size(0), -1)

            optimizer.zero_grad()
            
            ##3. RUN BACKPROP
           
           

            # print statistics
            running_loss += loss.item()
            if i % 500 == 499:    # print every 500 mini-batches
                print('[%d, %5d] loss: %.3f' %
                      (epoch + 1, i + 1, running_loss / 500))
                running_loss = 0.0
                
    print('Training finished')

def evaluate():
    dataiter = iter(load_data())
    images, labels = dataiter.next()

    # print images
    show_image(utils.make_grid(images))
    print('GroundTruth: ', ' '.join('%5s' % classes[labels[j]] for j in range(4)))
    
    images = images.view(images.size(0), -1)
    outputs = model(images)
    
    _, predicted = torch.max(outputs, 1)

    print('Predicted: ', ' '.join('%5s' % classes[predicted[j]]
                              for j in range(4)))

## 1. DEFINE MODEL 
model = nn.Sequential(nn.Linear(3072, 128),
                          nn.ReLU(),
                          nn.Linear(128, 64),
                          nn.ReLU(),
                          nn.Linear(64, 10)
                          )

##2. LOSS AND OPTIMIZER
criterion = nn.CrossEntropyLoss()
optimizer = optim.SGD(model.parameters(), lr=0.001, momentum=0.9)

##3. RUN BACKPROP
outputs = model(inputs)
loss = criterion(outputs, labels)
loss.backward()
optimizer.step()