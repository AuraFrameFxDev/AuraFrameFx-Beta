/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package dev.aurakai.auraframefx.api.client.apis

import java.io.IOException
import okhttp3.Call
import okhttp3.HttpUrl

import dev.aurakai.auraframefx.api.client.models.TaskScheduleRequest
import dev.aurakai.auraframefx.api.client.models.TaskStatus

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.aurakai.auraframefx.api.client.infrastructure.ApiClient
import dev.aurakai.auraframefx.api.client.infrastructure.ApiResponse
import dev.aurakai.auraframefx.api.client.infrastructure.ClientException
import dev.aurakai.auraframefx.api.client.infrastructure.ClientError
import dev.aurakai.auraframefx.api.client.infrastructure.ServerException
import dev.aurakai.auraframefx.api.client.infrastructure.ServerError
import dev.aurakai.auraframefx.api.client.infrastructure.MultiValueMap
import dev.aurakai.auraframefx.api.client.infrastructure.PartConfig
import dev.aurakai.auraframefx.api.client.infrastructure.RequestConfig
import dev.aurakai.auraframefx.api.client.infrastructure.RequestMethod
import dev.aurakai.auraframefx.api.client.infrastructure.ResponseType
import dev.aurakai.auraframefx.api.client.infrastructure.Success
import dev.aurakai.auraframefx.api.client.infrastructure.toMultiValue

public class TasksApi(basePath: kotlin.String = defaultBasePath, client: Call.Factory = ApiClient.defaultClient) : ApiClient(basePath, client) {
    public companion object {
        @JvmStatic
        public val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "https://api.auraframefx.com/v1")
        }
    }

    /**
     * POST /tasks/schedule
     * Schedule a new task
     * 
     * @param taskScheduleRequest 
     * @return TaskStatus
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    public fun tasksSchedulePost(taskScheduleRequest: TaskScheduleRequest) : TaskStatus {
        public val localVarResponse = tasksSchedulePostWithHttpInfo(taskScheduleRequest = taskScheduleRequest)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as TaskStatus
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                public val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                public val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * POST /tasks/schedule
     * Schedule a new task
     * 
     * @param taskScheduleRequest 
     * @return ApiResponse<TaskStatus?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    public fun tasksSchedulePostWithHttpInfo(taskScheduleRequest: TaskScheduleRequest) : ApiResponse<TaskStatus?> {
        public val localVariableConfig = tasksSchedulePostRequestConfig(taskScheduleRequest = taskScheduleRequest)

        return request<TaskScheduleRequest, TaskStatus>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation tasksSchedulePost
     *
     * @param taskScheduleRequest 
     * @return RequestConfig
     */
    public fun tasksSchedulePostRequestConfig(taskScheduleRequest: TaskScheduleRequest) : RequestConfig<TaskScheduleRequest> {
        public val localVariableBody = taskScheduleRequest
        public val localVariableQuery: MultiValueMap = mutableMapOf()
        public val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/tasks/schedule",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * GET /tasks/{taskId}
     * Get task status
     * 
     * @param taskId ID of the task to check
     * @return TaskStatus
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    public fun tasksTaskIdGet(taskId: kotlin.String) : TaskStatus {
        public val localVarResponse = tasksTaskIdGetWithHttpInfo(taskId = taskId)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as TaskStatus
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                public val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                public val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * GET /tasks/{taskId}
     * Get task status
     * 
     * @param taskId ID of the task to check
     * @return ApiResponse<TaskStatus?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    public fun tasksTaskIdGetWithHttpInfo(taskId: kotlin.String) : ApiResponse<TaskStatus?> {
        public val localVariableConfig = tasksTaskIdGetRequestConfig(taskId = taskId)

        return request<Unit, TaskStatus>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation tasksTaskIdGet
     *
     * @param taskId ID of the task to check
     * @return RequestConfig
     */
    public fun tasksTaskIdGetRequestConfig(taskId: kotlin.String) : RequestConfig<Unit> {
        public val localVariableBody = null
        public val localVariableQuery: MultiValueMap = mutableMapOf()
        public val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/tasks/{taskId}".replace("{"+"taskId"+"}", encodeURIComponent(taskId.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}
