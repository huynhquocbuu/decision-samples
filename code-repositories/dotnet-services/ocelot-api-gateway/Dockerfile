FROM mcr.microsoft.com/dotnet/aspnet:6.0 AS base
WORKDIR /app
EXPOSE 80

FROM mcr.microsoft.com/dotnet/sdk:6.0 AS build
WORKDIR /src
COPY ["ocelot-api-gateway.csproj", "./"]
RUN dotnet restore "./ocelot-api-gateway.csproj"
COPY . .
RUN dotnet build "ocelot-api-gateway.csproj" -c Release -o /app

FROM build AS publish
RUN dotnet publish "ocelot-api-gateway.csproj" -c Release -o /app

FROM base AS final
WORKDIR /app
COPY --from=publish /app .
ENTRYPOINT ["dotnet", "ocelot-api-gateway.dll"]