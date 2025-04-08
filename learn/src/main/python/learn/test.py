from openai import OpenAI

client = OpenAI(api_key="", base_url="https://api.deepseek.com")

response = client.chat.completions.create(
    model="deepseek-chat",
    messages=[
        {"role": "system", "content": "你是一个翻译专家，擅长英语、日语和中文"},
        {"role": "user", "content": "How can i make mony?"},
    ],
    stream=False
)

print(response.choices[0].message.content)