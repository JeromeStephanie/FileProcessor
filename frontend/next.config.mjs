export async function rewrites() {
    return [
        {
            source: '/process/process-file/:path*',
            destination: 'http://localhost:8080/process-file/:path*' // Proxy to Spring Boot backend
        }
    ]
}

